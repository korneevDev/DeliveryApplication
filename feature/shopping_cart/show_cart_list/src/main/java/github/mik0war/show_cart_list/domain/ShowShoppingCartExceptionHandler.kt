package github.mik0war.show_cart_list.domain

import github.mik0war.recycler_list.R as RList

import github.mik0war.entity.ExceptionHandler
import github.mik0war.entity.NoCachedDishesException
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dishCounted.DishCounted
import github.mik0war.show_cart_list.R
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
                        ?: stringContext.getString(RList.string.error_message_unknown_error)
                )
        }
}