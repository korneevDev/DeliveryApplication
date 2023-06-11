package github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache

interface CacheDataSource<T> {
    fun changeDishCount(dish: T, count: Int)
}