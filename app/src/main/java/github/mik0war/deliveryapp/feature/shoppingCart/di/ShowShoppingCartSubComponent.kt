package github.mik0war.deliveryapp.feature.shoppingCart.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.shoppingCart.presentation.ShowShoppingCartFragment

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
