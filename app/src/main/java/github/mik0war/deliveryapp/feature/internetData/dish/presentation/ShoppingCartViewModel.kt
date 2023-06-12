package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartFillViewModel
import javax.inject.Inject

interface ShoppingCartViewModel {
    fun addDishOnShoppingCart(dish: DishUIModel)

    class Base(application: DeliveryApp): ShoppingCartViewModel {
        init {
            application.appComponent.fillCartSubComponent().create().inject(this)
        }

        @Inject
        lateinit var shoppingCartViewModel: ShoppingCartFillViewModel<DishUIModel>

        override fun addDishOnShoppingCart(dish: DishUIModel) {
            shoppingCartViewModel.changeDishCountOnShoppingCart(dish, 1)
        }
    }
}