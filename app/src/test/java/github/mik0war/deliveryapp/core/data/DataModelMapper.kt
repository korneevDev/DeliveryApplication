package github.mik0war.deliveryapp.core.data

import github.mik0war.deliveryapp.entity.mapper.CategoryMapper
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryServerModel
import github.mik0war.deliveryapp.entity.DataMapper

class DataModelMapper(
    private val mapper: CategoryMapper<CategoryDataModel>
): DataMapper<CategoryServerModel, CategoryDataModel> {
    override fun map(dataObject: CategoryServerModel): CategoryDataModel = dataObject.map(mapper)
}