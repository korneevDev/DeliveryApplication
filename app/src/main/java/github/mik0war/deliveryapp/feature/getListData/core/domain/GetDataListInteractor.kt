package github.mik0war.deliveryapp.feature.getListData.core.domain

import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.ExceptionHandler
import javax.inject.Inject

interface GetDataListInteractor<R> {
    suspend fun getDataList(tags: List<String> = emptyList()): List<R>

    class Base<S : Entity, R : Entity> @Inject constructor(
        private val repository: GetDataListRepository<S>,
        private val mapper: DataMapper<S, R>,
        private val exceptionHandler: ExceptionHandler<R>
    ) : GetDataListInteractor<R> {
        override suspend fun getDataList(tags: List<String>): List<R> =
            try {
                repository.getCategoryList()
                    .getFilteredList(tags)
                    .map { mapper.map(it) }
            } catch (e: Exception) {
                listOf(exceptionHandler.mapExceptionToModel(e))
            }

        private fun <T: Entity> List<T>.getFilteredList(tags: List<String>): List<T>{
            return if(tags.isNotEmpty()) this.filter { it.filter(tags) } else this
        }
        private fun Entity.filter(tags: List<String>): Boolean =
            getTagsForFilter().containsAll(tags)
    }
}