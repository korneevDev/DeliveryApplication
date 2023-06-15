package github.mik0war.deliveryapp.feature.getListData.dish.domain

import github.mik0war.recycler_list.R
import github.mik0war.entity.ExceptionHandler
import github.mik0war.entity.NoConnectionException
import github.mik0war.entity.ServiceUnavailableException
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dish.Dish
import javax.inject.Inject


class DishExceptionHandler @Inject constructor(
    private val stringContext: StringResourceProvider
): ExceptionHandler<Dish> {
    override fun mapExceptionToModel(exception: Exception): Dish =
        when(exception){
            is NoConnectionException ->
                Dish.Error(stringContext.getString(R.string.error_message_no_connection))
            is ServiceUnavailableException ->
                Dish.Error(
                    stringContext.getString(R.string.error_message_service_unavailable)
                )
            else ->
                Dish.Error(
                    exception.message
                        ?: stringContext.getString(R.string.error_message_unknown_error)
                )
        }
}