package github.mik0war.deliveryapp.feature.internetData.dish.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishDataModel
import github.mik0war.deliveryapp.feature.internetData.dish.data.cloud.DishCloudDataSource

@Module
abstract class DishDataBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: DishCloudDataSource):
            CloudDataSource<DishDataModel>
}