package github.mik0war.deliveryapp.entity.dish

import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper

abstract class DishEntity(
    protected val id: Int,
    protected val name: String,
    protected val price: Int,
    protected val weight: Int,
    protected val description: String,
    protected val image_url: String,
    protected val tags: List<String>
) : Entity{

    override fun <S: Mapper<R>, R> map(mapper: S) =
        (mapper as DishMapper<R>).map(id, name, price, weight, description, image_url, tags)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DishEntity) return false

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