package github.mik0war.deliveryapp.feature.internetData.category.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity

data class CategoryListServerModel(
    @SerializedName("сategories")
    private val categories: List<CategoryServerModel>
){
    fun getList() = categories
}

data class CategoryServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("image_url")
    private val imageUrl: String
) : Entity {
    override fun<T> map(mapper: CategoryMapper<T>) = mapper.map(id, name, imageUrl)
}