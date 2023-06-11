package github.mik0war.deliveryapp.feature.internetData.dish.domain

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.feature.internetData.core.core.NoConnectionException
import github.mik0war.deliveryapp.feature.internetData.core.core.ServiceUnavailableException
import github.mik0war.deliveryapp.feature.internetData.core.core.StringResourceProvider
import github.mik0war.deliveryapp.feature.internetData.core.domain.ExceptionHandler
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