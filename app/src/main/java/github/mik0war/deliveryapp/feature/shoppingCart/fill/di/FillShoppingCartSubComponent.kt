package github.mik0war.deliveryapp.feature.shoppingCart.fill.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.getListData.dish.presentation.ShoppingCartCommunicationViewModelFromDishList
import github.mik0war.deliveryapp.feature.shoppingCart.show.presentation.ShoppingCartCommunicationViewModelFromCart

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

    fun inject(shoppingCartViewModel: ShoppingCartCommunicationViewModelFromDishList)
    fun inject(shoppingCartViewModel: ShoppingCartCommunicationViewModelFromCart)

}
