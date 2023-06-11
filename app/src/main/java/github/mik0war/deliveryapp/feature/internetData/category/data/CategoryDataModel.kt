package github.mik0war.deliveryapp.feature.internetData.category.data

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity

data class CategoryDataModel(
    private val id: Int,
    private val name: String,
    private val imageUrl: String
) : Entity {
    override fun <R, T> map(mapper: R): T =
        (mapper as CategoryMapper<T>).map(id, name, imageUrl)
}
