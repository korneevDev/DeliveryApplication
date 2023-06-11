package github.mik0war.deliveryapp.entity

interface ExceptionHandler<T> {
    fun mapExceptionToModel(exception: Exception): T
}

