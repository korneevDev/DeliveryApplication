package github.mik0war.category.data

import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.category.CategoryDataModel
import github.mik0war.recycler_list.data.CloudGetDataListDataSource
import javax.inject.Inject

class CategoryCloudGetDataListDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val mapper: DataMapper<CategoryServerModel, CategoryDataModel>
) : CloudGetDataListDataSource.Base<CategoryDataModel>() {

    override suspend fun getDataFromCloud() =
        categoryService.getListObject().getList().map { mapper.map(it) }
}