package github.mik0war.deliveryapp.feature.category.presentation

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import javax.inject.Inject

class MapperToUIModel @Inject constructor(): CategoryMapper<CategoryUIModel> {
    override fun map(id: Int, name: String, imageUrl: String) =
        CategoryUIModel.Success(id, name, imageUrl)
}