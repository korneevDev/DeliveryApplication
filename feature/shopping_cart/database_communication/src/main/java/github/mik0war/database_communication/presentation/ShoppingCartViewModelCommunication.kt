package github.mik0war.database_communication.presentation

import kotlinx.coroutines.Job

interface ShoppingCartViewModelCommunication<T> {
    fun addDishOnShoppingCart(dish: T, changeCount: Int): Job
    fun clearCart(): Job
}