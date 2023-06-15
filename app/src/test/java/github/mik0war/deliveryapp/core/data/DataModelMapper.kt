package github.mik0war.deliveryapp.core.data

import github.mik0war.deliveryapp.feature.getListData.category.data.CategoryServerModel
import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.category.CategoryDataModel
import github.mik0war.entity.dataModel.mapper.CategoryMapperTo

class DataModelMapper(
    private val mapper: CategoryMapperTo<CategoryDataModel>
): DataMapper<CategoryServerModel, CategoryDataModel> {
    override fun map(dataObject: CategoryServerModel): CategoryDataModel = dataObject.map(mapper)
}