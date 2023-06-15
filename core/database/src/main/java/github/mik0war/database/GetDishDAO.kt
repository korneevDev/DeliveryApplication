package github.mik0war.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface GetDishDAO {

    @Query("Select * FROM dish")
    fun getDishList(): List<DishCacheModel>
}