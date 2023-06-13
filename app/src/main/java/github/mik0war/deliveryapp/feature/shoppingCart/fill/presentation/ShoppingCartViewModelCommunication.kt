package github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation

import kotlinx.coroutines.Job

interface ShoppingCartViewModelCommunication<T> {
    fun addDishOnShoppingCart(dish: T, changeCount: Int): Job

    fun clearCart(): Job
}