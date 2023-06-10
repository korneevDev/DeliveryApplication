package github.mik0war.deliveryapp.feature.internetData.core.domain

interface ExceptionHandler<T> {
    fun mapExceptionToModel(exception: Exception): T
}

