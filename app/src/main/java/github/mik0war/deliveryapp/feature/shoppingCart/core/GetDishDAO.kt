package github.mik0war.deliveryapp.feature.shoppingCart.core

import androidx.room.Dao
import androidx.room.Query
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel

@Dao
interface GetDishDAO {

    @Query("Select * FROM dish")
    fun getDishList(): List<DishCacheModel>
}