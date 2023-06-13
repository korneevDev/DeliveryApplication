package github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation

interface ShoppingCartViewModel<T> {
    fun addDishOnShoppingCart(dish: T, changeCount: Int)
}