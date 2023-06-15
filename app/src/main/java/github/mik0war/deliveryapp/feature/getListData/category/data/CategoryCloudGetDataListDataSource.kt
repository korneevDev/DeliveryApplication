package github.mik0war.deliveryapp.feature.getListData.category.data

import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.category.CategoryDataModel
import javax.inject.Inject

class CategoryCloudGetDataListDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val mapper: DataMapper<CategoryServerModel, CategoryDataModel>
) : github.mik0war.recycler_list.core.data.CloudGetDataListDataSource.Base<CategoryDataModel>() {

    override suspend fun getDataFromCloud() =
        categoryService.getListObject().getList().map { mapper.map(it) }
}