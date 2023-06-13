package github.mik0war.deliveryapp.feature.shoppingCart.core

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel

@Dao
interface DishDAO {

    @Query("SELECT * FROM dish WHERE id=:id")
    fun getDishByID(id: Int) : DishCacheModel?

    @Query("Delete FROM dish")
    fun clearTable()

    @Update
    fun update(dish: DishCacheModel)

    @Insert
    fun create(dish: DishCacheModel)

    @Delete
    fun delete(dish: DishCacheModel)
}