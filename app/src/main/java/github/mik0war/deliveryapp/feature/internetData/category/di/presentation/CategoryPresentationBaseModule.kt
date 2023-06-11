package github.mik0war.deliveryapp.feature.internetData.category.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataLiveData
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataViewModel

@Module
abstract class CategoryPresentationBaseModule {
    @Binds
    abstract fun bindVM(viewModel: InternetDataViewModel.Base<Category, CategoryUIModel>):
            InternetDataViewModel<CategoryUIModel>

    @Binds
    abstract fun bindLiveData(liveData: InternetDataLiveData.Base<CategoryUIModel>):
            InternetDataLiveData<CategoryUIModel>
}