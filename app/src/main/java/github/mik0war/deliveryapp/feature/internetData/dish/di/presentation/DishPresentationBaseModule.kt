package github.mik0war.deliveryapp.feature.internetData.dish.di.presentation

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataLiveData
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataViewModel
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishUIModel

@Module
abstract class DishPresentationBaseModule {
    @Binds
    abstract fun bindVM(viewModel: InternetDataViewModel.Base<Dish, DishUIModel>):
            InternetDataViewModel<DishUIModel>

    @Binds
    abstract fun bindLiveData(liveData: InternetDataLiveData.Base<DishUIModel>):
            InternetDataLiveData<DishUIModel>
}