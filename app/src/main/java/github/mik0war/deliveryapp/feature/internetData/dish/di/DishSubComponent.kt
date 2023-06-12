package github.mik0war.deliveryapp.feature.internetData.dish.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.internetData.dish.di.data.DishBindsModule
import github.mik0war.deliveryapp.feature.internetData.dish.di.data.DishProvidesModule
import github.mik0war.deliveryapp.feature.internetData.dish.presentation.DishListFragment

@Subcomponent(modules = [
    DishBindsModule::class,
    DishProvidesModule::class
])
interface DishSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): DishSubComponent
    }

    fun inject(fragment: DishListFragment)

}