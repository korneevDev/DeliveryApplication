package github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.data.cache

interface CacheDataSource<T> {
    fun changeDishCount(dish: T, count: Int)
}