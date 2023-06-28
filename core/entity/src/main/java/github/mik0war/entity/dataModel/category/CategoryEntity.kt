package github.mik0war.entity.dataModel.category

import github.mik0war.entity.Entity
import github.mik0war.entity.dataModel.mapper.CategoryMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo

sealed class CategoryEntity(
    protected val name: String
) : Entity {
    abstract class Success(
        protected val id: Int,
        name: String,
        protected val imageUrl: String
    ): CategoryEntity(name){
        override fun getTagsForFilter(): List<String> = emptyList()

        @Suppress("UNCHECKED_CAST")
        override fun <R : MapperTo<T>, T> map(mapper: R): T =
            (mapper as CategoryMapperTo<T>).map(id, name, imageUrl)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Success) return false

            if (id != other.id) return false
            if (name != other.name) return false
            if (imageUrl != other.imageUrl) return false

            return true
        }

        protected fun equalsId(other: Success): Boolean = this.id == other.id

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + name.hashCode()
            result = 31 * result + imageUrl.hashCode()
            return result
        }
    }

    abstract class Error(
        name: String
    ) : CategoryEntity(name){

        override fun <R : MapperTo<T>, T> map(mapper: R): T  =
            mapper.mapError(name)

        override fun getTagsForFilter(): List<String> = emptyList()
    }


}