package github.mik0war.deliveryapp.entity.dish

import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper


sealed class Dish(
    protected val name: String
) : Entity {
    override fun <S: Mapper<R>, R> map(mapper: S) =
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
        override fun <S: Mapper<R>, R> map(mapper: S) =
            (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
    }

    class Error(message: String): Dish(message)
}