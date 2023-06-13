package github.mik0war.deliveryapp.feature.getListData.category.data

import com.google.gson.annotations.SerializedName
import github.mik0war.deliveryapp.entity.mapper.CategoryMapperTo
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.MapperTo

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
    override fun getTagsForFilter(): List<String> = emptyList()

    override fun <R: MapperTo<T>, T> map(mapper: R): T = (mapper as CategoryMapperTo<T>).map(id, name, imageUrl)
}