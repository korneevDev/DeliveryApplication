package github.mik0war.dish.data

import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.recycler_list.data.CloudGetDataListDataSource
import javax.inject.Inject

class DishCloudGetDataListDataSource @Inject constructor(
    private val dishService: DishService,
    private val mapper: DataMapper<DishServerModel, DishDataModel>
) : CloudGetDataListDataSource.Base<DishDataModel>() {

    override suspend fun getDataFromCloud() =
        dishService.getListObject().getList().map { mapper.map(it) }
}