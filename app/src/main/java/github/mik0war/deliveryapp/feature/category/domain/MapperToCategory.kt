package github.mik0war.deliveryapp.feature.category.domain

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import javax.inject.Inject

class MapperToCategory @Inject constructor() : CategoryMapper<Category> {
    override fun map(id: Int, name: String, imageIrl: String) =
        Category.Success(id, name, imageIrl)
}