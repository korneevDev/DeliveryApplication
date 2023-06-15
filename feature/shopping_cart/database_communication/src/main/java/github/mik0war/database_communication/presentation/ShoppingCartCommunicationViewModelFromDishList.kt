package github.mik0war.database_communication.presentation

import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.entity.dataModel.dish.DishUIModel
import javax.inject.Inject

class ShoppingCartCommunicationViewModelFromDishList(application: FillShoppingCartSubComponentProvider) :
    ShoppingCartViewModelCommunication<DishUIModel> {
    init {
        application.provideFillShoppingCartSubComponent().inject(this)
    }

    @Inject
    lateinit var shoppingCartViewModel: ShoppingCartFillViewModel<DishUIModel>

    override fun addDishOnShoppingCart(dish: DishUIModel, changeCount: Int) =
        shoppingCartViewModel.changeDishCountOnShoppingCart(dish, changeCount)

    override fun clearCart() = shoppingCartViewModel.clearCart()
}