package github.mik0war.deliveryapp.feature.internetData.dish.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.internetData.dish.di.data.DishDataBindsModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.data.DishDataProviderModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.domain.DishDomainBindsModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.domain.DishDomainProviderModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.presentation.DishPresentationBaseModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.presentation.DishPresentationProviderModule
import github.mik0war.deliveryapp.feature.internetData.dish.presentation.DishListFragment

@Subcomponent(modules = [
    DishDataBindsModule::class,
    DishDataProviderModule::class,
    DishDomainBindsModule::class,
    DishDomainProviderModule::class,
    DishPresentationBaseModule::class,
    DishPresentationProviderModule::class
])
interface DishSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): DishSubComponent
    }

    fun inject(fragment: DishListFragment)
}