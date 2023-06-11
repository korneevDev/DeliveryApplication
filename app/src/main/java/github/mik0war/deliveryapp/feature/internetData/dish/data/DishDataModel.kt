package github.mik0war.deliveryapp.feature.internetData.dish.data

import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper

data class DishDataModel(
    private val id: Int,
    private val name: String,
    private val price: Int,
    private val weight: Int,
    private val description: String,
    private val imageUrl: String,
    private val tags: List<String>,
) : Entity {

    override fun <S, R> map(mapper: S) =
        (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
}