package github.mik0war.dish.di

import dagger.Subcomponent
import github.mik0war.dish.presentation.DishListFragment

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

interface DishSubComponentProvider{
    fun provideDishSubComponent(): DishSubComponent
}