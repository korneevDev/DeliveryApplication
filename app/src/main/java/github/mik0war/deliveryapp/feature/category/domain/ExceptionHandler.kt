package github.mik0war.deliveryapp.feature.category.domain

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.feature.category.core.NoConnectionException
import github.mik0war.deliveryapp.feature.category.core.ServiceUnavailableException
import github.mik0war.deliveryapp.feature.category.core.StringResourceProvider
import java.lang.Exception
import javax.inject.Inject

interface ExceptionHandler {
    fun mapExceptionToModel(exception: Exception): Category

    class Base @Inject constructor(
        private val stringContext: StringResourceProvider
        ): ExceptionHandler {
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
                        exception.message ?:
                        stringContext.getString(R.string.error_message_unknown_error)
                    )
            }
    }
}