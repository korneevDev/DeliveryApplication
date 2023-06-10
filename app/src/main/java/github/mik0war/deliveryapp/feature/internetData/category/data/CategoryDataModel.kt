package github.mik0war.deliveryapp.feature.internetData.category.data

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import javax.inject.Inject

data class CategoryDataModel(
    private val id: Int,
    private val name: String,
    private val imageIrl: String
) : Entity {
    override fun <T> map(mapper: CategoryMapper<T>) = mapper.map(id, name, imageIrl)
}

class MapperToCategoryDataModel @Inject constructor() : CategoryMapper<CategoryDataModel> {
    override fun map(id: Int, name: String, imageUrl: String) = CategoryDataModel(id, name, imageUrl)
}
