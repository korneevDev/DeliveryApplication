package github.mik0war.deliveryapp.feature.shoppingCart.fill.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.internetData.dish.presentation.ShoppingCartViewModel

@Subcomponent(
    modules = [
        FillCartBindsModule::class,
        FillCartProvidesModule::class
    ]
)
interface FillShoppingCartSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FillShoppingCartSubComponent
    }

    fun inject(shoppingCartViewModel: ShoppingCartViewModel.Base)

}
