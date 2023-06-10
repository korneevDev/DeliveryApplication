package github.mik0war.deliveryapp.feature.internetData.category.domain

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.feature.internetData.core.core.NoConnectionException
import github.mik0war.deliveryapp.feature.internetData.core.core.ServiceUnavailableException
import github.mik0war.deliveryapp.feature.internetData.core.core.StringResourceProvider
import github.mik0war.deliveryapp.feature.internetData.core.domain.ExceptionHandler
import javax.inject.Inject

class CategoryExceptionHandler @Inject constructor(
    private val stringContext: StringResourceProvider
): ExceptionHandler<Category> {
    override fun mapExceptionToModel(exception: Exception): Category =
        when(exception){
            is NoConnectionException ->
                Category.Error(stringContext.getString(R.string.error_message_no_connection))
            is ServiceUnavailableException ->
                Category.Error(
                    stringContext.getString(R.string.error_message_service_unavailable)
                )
            else ->
                Category.Error(
                    exception.message
                        ?: stringContext.getString(R.string.error_message_unknown_error)
                )
        }
}