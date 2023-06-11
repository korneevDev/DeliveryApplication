package github.mik0war.deliveryapp.feature.internetData.dish.domain

import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper


sealed class Dish(
    protected val name: String
) : Entity {
    override fun <S, R> map(mapper: S) =
        (mapper as DishMapper<R>)
            .map(0, name, 0, 0, "", "", emptyList())

    class Success(
        private val id: Int,
        name: String,
        private val price: Int,
        private val weight: Int,
        private val description: String,
        private val imageUrl: String,
        private val tags: List<String>,
    ) : Dish(name){
        override fun <S, R> map(mapper: S) =
            (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
    }

    class Error(message: String): Dish(message)
}