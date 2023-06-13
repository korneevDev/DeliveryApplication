package github.mik0war.deliveryapp.feature.getListData.category.data

import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.feature.getListData.core.data.CloudGetDataListDataSource
import javax.inject.Inject

class CategoryCloudGetDataListDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val mapper: DataMapper<CategoryServerModel, CategoryDataModel>
) : CloudGetDataListDataSource.Base<CategoryDataModel>() {

    override suspend fun getDataFromCloud() =
        categoryService.getListObject().getList().map { mapper.map(it) }
}