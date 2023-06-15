package github.mik0war.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson


@Database(
    entities = [DishCacheModel::class],
    version = 1,
    exportSchema = false

)
@TypeConverters(value = [Converters::class])
abstract class DishDataBase : RoomDatabase(){
    abstract fun fillShoppingCartDAO(): DishDAO
    abstract fun getDishListDAO(): GetDishDAO
}

class Converters {

    @TypeConverter
    fun listToJson(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<String>::class.java).toList()
}