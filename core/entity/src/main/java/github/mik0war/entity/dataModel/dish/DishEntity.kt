package github.mik0war.entity.dataModel.dish

import github.mik0war.entity.Entity
import github.mik0war.entity.dataModel.mapper.DishMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo

sealed interface DishEntity: Entity {

    abstract class Success(
        protected val id: Int,
        protected val name: String,
        protected val price: Int,
        protected val weight: Int,
        protected val description: String,
        protected val image_url: String,
        protected val tags: List<String>
    ) : DishEntity {
        override fun getTagsForFilter() = tags

        @Suppress("UNCHECKED_CAST")
        override fun <S : MapperTo<R>, R> map(mapper: S) =
            (mapper as DishMapperTo<R>).map(id, name, price, weight, description, image_url, tags)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Success) return false

            if (id != other.id) return false
            if (name != other.name) return false
            if (price != other.price) return false
            if (weight != other.weight) return false
            if (description != other.description) return false
            if (image_url != other.image_url) return false
            if (tags != other.tags) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id
            result = 31 * result + name.hashCode()
            result = 31 * result + price
            result = 31 * result + weight
            result = 31 * result + description.hashCode()
            result = 31 * result + image_url.hashCode()
            result = 31 * result + tags.hashCode()
            return result
        }
    }

    abstract class Error(
        protected val errorMessage: String
    ) : DishEntity{
        override fun <R : MapperTo<T>, T> map(mapper: R): T =
            mapper.mapError(errorMessage)

        override fun getTagsForFilter(): List<String> = emptyList()
    }
}