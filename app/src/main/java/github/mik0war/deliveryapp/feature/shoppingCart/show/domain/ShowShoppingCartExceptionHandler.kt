package github.mik0war.deliveryapp.feature.shoppingCart.show.domain

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.ExceptionHandler
import github.mik0war.deliveryapp.entity.NoCachedDishesException
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dishCounted.DishCounted
import javax.inject.Inject

class ShowShoppingCartExceptionHandler @Inject constructor(
    private val stringContext: StringResourceProvider
): ExceptionHandler<DishCounted> {
    override fun mapExceptionToModel(exception: Exception): DishCounted =
        when(exception){
            is NoCachedDishesException ->
                DishCounted.Error(stringContext.getString(R.string.error_no_dishes_in_shopping_cart))
            else ->
                DishCounted.Error(
                    exception.message
                        ?: stringContext.getString(R.string.error_message_unknown_error)
                )
        }
}