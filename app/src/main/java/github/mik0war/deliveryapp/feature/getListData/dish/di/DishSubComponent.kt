package github.mik0war.deliveryapp.feature.getListData.dish.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.getListData.dish.presentation.DishListFragment

@Subcomponent(modules = [
    DishBindsModule::class,
    DishProvidesModule::class,
    TagsModule::class
])
interface DishSubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): DishSubComponent
    }

    fun inject(fragment: DishListFragment)

}