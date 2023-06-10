package github.mik0war.deliveryapp.feature.internetData.category.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataLiveData
import github.mik0war.deliveryapp.feature.internetData.category.presentation.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataViewModel
import github.mik0war.deliveryapp.feature.internetData.category.presentation.MapperToUIModel
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category

@Module
abstract class PresentationBaseModule {
    @Binds
    abstract fun bindVM(viewModel: InternetDataViewModel.Base<Category, CategoryUIModel>):
            InternetDataViewModel<CategoryUIModel>

    @Binds
    abstract fun bindMapperToUIModel(mapperToUIModel: MapperToUIModel):
            CategoryMapper<CategoryUIModel>

    @Binds
    abstract fun bindLiveData(liveData: InternetDataLiveData.Base<CategoryUIModel>):
            InternetDataLiveData<CategoryUIModel>
}