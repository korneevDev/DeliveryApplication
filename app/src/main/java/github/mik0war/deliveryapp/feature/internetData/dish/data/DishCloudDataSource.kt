package github.mik0war.deliveryapp.feature.internetData.dish.data

import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import javax.inject.Inject

class DishCloudDataSource @Inject constructor(
    private val dishService: DishService,
    private val mapper: DataMapper<DishServerModel, DishDataModel>
) : CloudDataSource.Base<DishDataModel>() {

    override suspend fun getDataFromCloud() =
        dishService.getListObject().getList().map { mapper.map(it) }
}