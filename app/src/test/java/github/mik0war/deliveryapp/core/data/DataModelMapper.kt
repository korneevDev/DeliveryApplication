package github.mik0war.deliveryapp.core.data

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.cloud.CategoryServerModel
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

class DataModelMapper(
    private val mapper: CategoryMapper<CategoryDataModel>
): InternetDataMapper<CategoryServerModel, CategoryDataModel> {
    override fun map(dataObject: CategoryServerModel) = dataObject.map(mapper)
}