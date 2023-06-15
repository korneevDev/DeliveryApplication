package github.mik0war.deliveryapp.feature.shoppingCart.fill.domain

interface FillCartRepository<T> {
    suspend fun saveDish(dish: T, count: Int)

    suspend fun clearTable()
}