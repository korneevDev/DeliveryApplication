package github.mik0war.deliveryapp.feature.category.data.cloud

import com.google.gson.annotations.SerializedName
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel

data class CategoryListServerModel(
    @SerializedName("categories")
    private val categories: List<CategoryServerModel>
){
    fun getCategoriesList() = categories
}

data class CategoryServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("image_Url")
    private val imageUrl: String
){
    fun map(mapper: CategoryMapper<CategoryDataModel>) = mapper.map(id, name, imageUrl)
}