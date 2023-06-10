package github.mik0war.deliveryapp.feature.internetData.category.data.cloud

import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import javax.inject.Inject

class CategoryCloudDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val mapper: InternetDataMapper<CategoryServerModel, CategoryDataModel>
) : CloudDataSource.Base<CategoryDataModel>() {

    override suspend fun getDataFromCloud() =
        categoryService.getListObject().getList().map { mapper.map(it) }

}