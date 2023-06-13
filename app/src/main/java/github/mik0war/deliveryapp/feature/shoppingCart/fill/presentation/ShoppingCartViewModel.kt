package github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation

import kotlinx.coroutines.Job

interface ShoppingCartViewModel<T> {
    fun addDishOnShoppingCart(dish: T, changeCount: Int): Job
}