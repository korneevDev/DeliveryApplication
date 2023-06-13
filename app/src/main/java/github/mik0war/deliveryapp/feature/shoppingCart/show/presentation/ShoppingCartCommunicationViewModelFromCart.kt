package github.mik0war.deliveryapp.feature.shoppingCart.show.presentation

import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartViewModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartFillViewModel
import javax.inject.Inject

class ShoppingCartCommunicationViewModelFromCart(application: DeliveryApp):
    ShoppingCartViewModel<DishCountedUIModel> {
    init {
        application.appComponent.fillCartSubComponent().create().inject(this)
    }

    @Inject
    lateinit var shoppingCartViewModel: ShoppingCartFillViewModel<DishCountedUIModel>

    override fun addDishOnShoppingCart(dish: DishCountedUIModel, changeCount: Int) {
        shoppingCartViewModel.changeDishCountOnShoppingCart(dish, changeCount)
    }
}