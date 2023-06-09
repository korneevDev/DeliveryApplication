package github.mik0war.deliveryapp.feature.category.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.presentation.CategoryLiveData
import github.mik0war.deliveryapp.feature.category.presentation.CategoryUIModel
import github.mik0war.deliveryapp.feature.category.presentation.CategoryViewModel
import github.mik0war.deliveryapp.feature.category.presentation.MapperToUIModel

@Module
abstract class PresentationBaseModule {
    @Binds
    abstract fun bindVM(viewModel: CategoryViewModel.Base): CategoryViewModel

    @Binds
    abstract fun bindMapperToUIModel(mapperToUIModel: MapperToUIModel):
            CategoryMapper<CategoryUIModel>

    @Binds
    abstract fun bindLiveData(liveData: CategoryLiveData.Base): CategoryLiveData
}