package github.mik0war.category.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.category.data.CategoryCloudGetDataListDataSource
import github.mik0war.entity.dataModel.category.CategoryDataModel
import github.mik0war.recycler_list.data.GetDataListDataSource

@Module
abstract class CategoryDataBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: CategoryCloudGetDataListDataSource):
            GetDataListDataSource<CategoryDataModel>
}