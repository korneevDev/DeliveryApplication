package github.mik0war.deliveryapp.feature.getListData.category.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.feature.getListData.category.data.CategoryCloudGetDataListDataSource
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListDataSource

@Module
abstract class CategoryDataBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: CategoryCloudGetDataListDataSource):
            GetDataListDataSource<CategoryDataModel>
}