package github.mik0war.show_cart_list.di

import dagger.Subcomponent
import github.mik0war.show_cart_list.presentation.ShowShoppingCartFragment

@Subcomponent(
    modules = [
        ShowCartBindsModule::class,
        ShowCartProvidesModule::class
    ]
)
interface ShowShoppingCartSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ShowShoppingCartSubComponent
    }

    fun inject(fragment: ShowShoppingCartFragment)

}

interface ShowShoppingCartSubComponentProvider{
    fun provideShowShoppingCartSubComponent(): ShowShoppingCartSubComponent
}
