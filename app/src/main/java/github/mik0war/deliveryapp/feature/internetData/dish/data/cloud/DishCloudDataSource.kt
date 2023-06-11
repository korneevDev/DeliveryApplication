package github.mik0war.deliveryapp.feature.internetData.dish.data.cloud

import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishDataModel
import javax.inject.Inject

class DishCloudDataSource @Inject constructor(
    private val dishService: DishService,
    private val mapper: InternetDataMapper<DishServerModel, DishDataModel>
) : CloudDataSource.Base<DishDataModel>() {

    override suspend fun getDataFromCloud() =
        dishService.getListObject().getList().map { mapper.map(it) }
}