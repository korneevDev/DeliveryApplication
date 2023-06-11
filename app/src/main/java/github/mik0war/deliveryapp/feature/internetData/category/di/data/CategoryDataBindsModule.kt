package github.mik0war.deliveryapp.feature.internetData.category.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryCloudDataSource
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource

@Module
abstract class CategoryDataBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: CategoryCloudDataSource):
            CloudDataSource<CategoryDataModel>
}