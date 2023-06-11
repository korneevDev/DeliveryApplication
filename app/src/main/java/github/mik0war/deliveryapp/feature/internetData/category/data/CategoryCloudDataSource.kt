package github.mik0war.deliveryapp.feature.internetData.category.data

import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import javax.inject.Inject

class CategoryCloudDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val mapper: DataMapper<CategoryServerModel, CategoryDataModel>
) : CloudDataSource.Base<CategoryDataModel>() {

    override suspend fun getDataFromCloud() =
        categoryService.getListObject().getList().map { mapper.map(it) }
}