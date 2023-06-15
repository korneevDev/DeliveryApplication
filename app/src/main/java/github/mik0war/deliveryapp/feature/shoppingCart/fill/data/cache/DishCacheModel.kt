package github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import github.mik0war.entity.dataModel.mapper.DishCountedMapperTo
import github.mik0war.entity.dataModel.mapper.DishMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo
import github.mik0war.entity.Entity as ProjectEntity

@Entity(tableName = "dish")
data class DishCacheModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "tags") val tags: List<String>,
) : ProjectEntity {
    @ColumnInfo(name = "count") var count: Int = 0
    fun updateCount(count: Int) = this.also { it.count += count }

    override fun getTagsForFilter(): List<String> = tags

    override fun <S: MapperTo<R>, R> map(mapper: S) =
        when(mapper){
            is DishMapperTo<*> ->
                (mapper as DishMapperTo<R>)
                    .map(id, name, price, weight, description, image_url, tags)
            is DishCountedMapperTo<*> ->
                (mapper as DishCountedMapperTo<R>)
                    .map(id, name, price, weight, description, image_url, tags, count)
            else -> throw IllegalArgumentException("$mapper cannot be cast")
        }


}