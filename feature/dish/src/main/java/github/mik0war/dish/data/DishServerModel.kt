package github.mik0war.dish.data

import com.google.gson.annotations.SerializedName
import github.mik0war.entity.Entity
import github.mik0war.entity.dataModel.mapper.DishMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo

data class DishListServerModel(
    @SerializedName("dishes")
    private val dishes: List<DishServerModel>
){
    fun getList() = dishes
}

data class DishServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("price")
    private val price: Int,
    @SerializedName("weight")
    private val weight: Int,
    @SerializedName("description")
    private val description: String,
    @SerializedName("image_url")
    private val imageUrl: String,
    @SerializedName("tegs")
    private val tags: List<String>,
) : Entity {
    override fun <S: MapperTo<R>, R> map(mapper: S) =
        (mapper as DishMapperTo<R>).map(id, name, price, weight, description, imageUrl, tags)

    override fun getTagsForFilter(): List<String> = tags
}