package github.mik0war.deliveryapp.feature.shoppingCart.fill.domain

import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.Entity
import javax.inject.Inject

interface Interactor<T> {
    suspend fun addDishToCart(dish: T, countChange: Int)
    suspend fun clearCart()

    class Base<S : Entity, R : Entity> @Inject constructor(
        private val repository: Repository<R>,
        private val mapper: DataMapper<S, R>
    ) : Interactor<S> {
        override suspend fun addDishToCart(dish: S, countChange: Int) =
            repository.saveDish(mapper.map(dish), countChange)

        override suspend fun clearCart() {
            repository.clearTable()
        }
    }
}