package github.mik0war.deliveryapp.feature.internetData.core.domain

import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import javax.inject.Inject

interface InternetDataInteractor<R> {
    suspend fun getDataList(): List<R>

    class Base<S: Entity, R: Entity> @Inject constructor(
        private val repository: InternetDataRepository<S>,
        private val mapper: InternetDataMapper<S, R>,
        private val exceptionHandler: ExceptionHandler<R>
    ): InternetDataInteractor<R> {
        override suspend fun getDataList(): List<R> =
            try {
                repository.getCategoryList().map { mapper.map(it) }
            }
            catch (e: Exception){
                listOf(exceptionHandler.mapExceptionToModel(e))
            }
    }
}