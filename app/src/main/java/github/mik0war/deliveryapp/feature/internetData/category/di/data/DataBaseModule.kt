package github.mik0war.deliveryapp.feature.internetData.category.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.MapperToCategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.category.data.cloud.CategoryCloudDataSource

@Module
abstract class DataBaseModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: CategoryCloudDataSource):
            CloudDataSource<CategoryDataModel>

    @Binds
    abstract fun bindMapperToCategoryDataModel(mapperToCategory: MapperToCategoryDataModel):
            CategoryMapper<CategoryDataModel>
}