package github.mik0war.deliveryapp.feature.internetData.dish.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper

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
    override fun <S, R> map(mapper: S) =
        (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
}