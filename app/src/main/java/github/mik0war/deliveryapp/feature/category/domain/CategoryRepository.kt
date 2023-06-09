package github.mik0war.deliveryapp.feature.category.domain

import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel

interface CategoryRepository{
    suspend fun getCategoryList(): List<CategoryDataModel>
}