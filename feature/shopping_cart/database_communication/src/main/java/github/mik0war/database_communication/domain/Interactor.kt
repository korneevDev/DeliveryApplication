package github.mik0war.database_communication.domain

import github.mik0war.entity.DataMapper
import github.mik0war.entity.Entity
import javax.inject.Inject

interface Interactor<T> {
    suspend fun addDishToCart(dish: T, countChange: Int)
    suspend fun clearCart()

    class Base<S : Entity, R : Entity> @Inject constructor(
        private val fillCartRepository: FillCartRepository<R>,
        private val mapper: DataMapper<S, R>
    ) : Interactor<S> {
        override suspend fun addDishToCart(dish: S, countChange: Int) =
            fillCartRepository.saveDish(mapper.map(dish), countChange)

        override suspend fun clearCart() {
            fillCartRepository.clearTable()
        }
    }
}