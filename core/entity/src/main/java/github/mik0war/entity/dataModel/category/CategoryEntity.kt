package github.mik0war.entity.dataModel.category

import github.mik0war.entity.Entity
import github.mik0war.entity.dataModel.mapper.CategoryMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo

abstract class CategoryEntity(
    protected val id: Int,
    protected val name: String,
    protected val imageUrl: String
) : Entity {
    override fun getTagsForFilter(): List<String> = emptyList()

    override fun <R : MapperTo<T>, T> map(mapper: R): T =
        (mapper as CategoryMapperTo<T>).map(id, name, imageUrl)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CategoryEntity) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (imageUrl != other.imageUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + imageUrl.hashCode()
        return result
    }


}