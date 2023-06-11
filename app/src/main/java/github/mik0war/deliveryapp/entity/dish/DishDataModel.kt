package github.mik0war.deliveryapp.entity.dish

import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper

data class DishDataModel(
    private val id: Int,
    private val name: String,
    private val price: Int,
    private val weight: Int,
    private val description: String,
    private val imageUrl: String,
    private val tags: List<String>,
) : Entity {

    override fun <S: Mapper<R>, R> map(mapper: S) =
        (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
}