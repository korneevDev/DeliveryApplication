package github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper
import github.mik0war.deliveryapp.entity.Entity as MyEntity

@Entity(tableName = "dish")
data class DishCacheModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "tags") val tags: List<String>,
) : MyEntity {
    @ColumnInfo(name = "count") var count: Int = 0
    fun updateCount(count: Int) = this.also { it.count += count }

    override fun <S: Mapper<R>, R> map(mapper: S) =
        (mapper as DishMapper<R>).map(id, name, price, weight, description, image_url, tags)

}