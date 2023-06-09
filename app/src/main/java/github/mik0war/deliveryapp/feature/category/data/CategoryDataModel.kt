package github.mik0war.deliveryapp.feature.category.data

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper

data class CategoryDataModel(
    private val id: Int,
    private val name: String,
    private val imageIrl: String
){
    fun <T> map(mapper: CategoryMapper<T>) = mapper.map(id, name, imageIrl)
}
