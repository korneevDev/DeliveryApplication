package github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache

import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDAO
import javax.inject.Inject

interface CacheDataSource<T> {
    fun changeDishCount(dish: T, count: Int)
    fun clearTable()

    class Base @Inject constructor(
        private val dishDAO: DishDAO,
    ): CacheDataSource<DishCacheModel> {
        override fun changeDishCount(dish: DishCacheModel, count: Int) {
            val dishFromDB = dishDAO.getDishByID(dish.id)

            if(dishFromDB == null) {
                if (count > 0)
                    dishDAO.create(dish.also { it.count = count })
            }
            else if(dishFromDB.count <= 0 || dishFromDB.count + count <= 0)
                dishDAO.delete(dishFromDB)
            else
                dishDAO.update(dishFromDB.updateCount(count))
        }

        override fun clearTable() {
            dishDAO.clearTable()
        }
    }
}