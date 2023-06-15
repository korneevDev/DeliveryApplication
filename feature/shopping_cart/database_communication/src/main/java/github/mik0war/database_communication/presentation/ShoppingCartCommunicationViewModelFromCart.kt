package github.mik0war.database_communication.presentation

import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel
import kotlinx.coroutines.Job
import javax.inject.Inject

class ShoppingCartCommunicationViewModelFromCart(application: FillShoppingCartSubComponentProvider):
    ShoppingCartViewModelCommunication<DishCountedUIModel> {
    init {
        application.provideFillShoppingCartSubComponent().inject(this)
    }

    @Inject
    lateinit var shoppingCartViewModel: ShoppingCartFillViewModel<DishCountedUIModel>

    override fun addDishOnShoppingCart(dish: DishCountedUIModel, changeCount: Int): Job =
        shoppingCartViewModel.changeDishCountOnShoppingCart(dish, changeCount)

    override fun clearCart() = shoppingCartViewModel.clearCart()

}