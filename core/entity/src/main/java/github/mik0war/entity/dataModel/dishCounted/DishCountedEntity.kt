package github.mik0war.entity.dataModel.dishCounted

import github.mik0war.entity.dataModel.dish.DishEntity
import github.mik0war.entity.dataModel.mapper.DishCountedMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo

abstract class DishCountedEntity(
    id: Int,
    name: String,
    price: Int,
    weight: Int,
    description: String,
    image_url: String,
    tags: List<String>,
    protected val count: Int
) : DishEntity.Success(id, name, price, weight, description, image_url, tags) {

    @Suppress("UNCHECKED_CAST")
    override fun <S : MapperTo<R>, R> map(mapper: S) =
        (mapper as DishCountedMapperTo<R>)
            .map(id, name, price, weight, description, image_url, tags, count)

    override fun equals(other: Any?): Boolean {
        if (!super.equals(other)) return false
        if (other !is DishCountedEntity) return false

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int {
        return 31 * super.hashCode() + count
    }
}