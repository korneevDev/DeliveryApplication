package github.mik0war.category.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.category.Category
import github.mik0war.entity.dataModel.category.CategoryUIModel
import github.mik0war.recycler_list.presentation.GetDataListLiveData
import github.mik0war.recycler_list.presentation.GetDataListViewModel

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