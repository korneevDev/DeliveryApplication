package github.mik0war.database_communication.di

import dagger.Subcomponent
import github.mik0war.database_communication.presentation.ShoppingCartCommunicationViewModelFromCart
import github.mik0war.database_communication.presentation.ShoppingCartCommunicationViewModelFromDishList

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

interface FillShoppingCartSubComponentProvider{
    fun provideFillShoppingCartSubComponent(): FillShoppingCartSubComponent
}
