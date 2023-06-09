package github.mik0war.deliveryapp.feature.category.data

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import javax.inject.Inject

class MapperToCategoryDataModel @Inject constructor() : CategoryMapper<CategoryDataModel> {
    override fun map(id: Int, name: String, imageUrl: String) = CategoryDataModel(id, name, imageUrl)
}