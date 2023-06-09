package github.mik0war.deliveryapp.feature.category.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.MapperToCategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.cloud.CloudDataSource

@Module
abstract class DataBaseModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: CloudDataSource.Base):
            CloudDataSource

    @Binds
    abstract fun bindMapperToCategoryDataModel(mapperToCategory: MapperToCategoryDataModel):
            CategoryMapper<CategoryDataModel>
}