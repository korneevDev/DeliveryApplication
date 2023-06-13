package github.mik0war.deliveryapp.feature.getListData.dish.data

import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.feature.getListData.core.data.CloudGetDataListDataSource
import javax.inject.Inject

class DishCloudGetDataListDataSource @Inject constructor(
    private val dishService: DishService,
    private val mapper: DataMapper<DishServerModel, DishDataModel>
) : CloudGetDataListDataSource.Base<DishDataModel>() {

    override suspend fun getDataFromCloud() =
        dishService.getListObject().getList().map { mapper.map(it) }
}