package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartFillViewModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartViewModel
import javax.inject.Inject

class ShoppingCartCommunicationViewModelFromDishList(application: DeliveryApp):
    ShoppingCartViewModel<DishUIModel> {
    init {
        application.appComponent.fillCartSubComponent().create().inject(this)
    }

    @Inject
    lateinit var shoppingCartViewModel: ShoppingCartFillViewModel<DishUIModel>

    override fun addDishOnShoppingCart(dish: DishUIModel, changeCount: Int) =
        shoppingCartViewModel.changeDishCountOnShoppingCart(dish, changeCount)

}