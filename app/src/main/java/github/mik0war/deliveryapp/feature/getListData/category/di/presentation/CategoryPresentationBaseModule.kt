package github.mik0war.deliveryapp.feature.getListData.category.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListLiveData
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel

@Module
abstract class CategoryPresentationBaseModule {
    @Binds
    abstract fun bindVM(viewModel: GetDataListViewModel.Base<Category, CategoryUIModel>):
            GetDataListViewModel<CategoryUIModel>

    @Binds
    abstract fun bindLiveData(liveData: GetDataListLiveData.Base<CategoryUIModel>):
            GetDataListLiveData<CategoryUIModel>

    @Binds
    abstract fun bindMapperCategoryCategoryUIModel(
        mapper: DataMapper.Base<Category, CategoryUIModel>
    ): DataMapper<Category, CategoryUIModel>
}