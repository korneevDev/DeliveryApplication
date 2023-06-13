package github.mik0war.deliveryapp.feature.shoppingCart.show.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.shoppingCart.show.presentation.ShowShoppingCartFragment

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
