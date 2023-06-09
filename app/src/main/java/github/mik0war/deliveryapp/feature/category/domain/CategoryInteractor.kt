package github.mik0war.deliveryapp.feature.category.domain

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import javax.inject.Inject

interface CategoryInteractor {
    suspend fun getCategoryList(): List<Category>

    class Base @Inject constructor(
        private val repository: CategoryRepository,
        private val mapper: CategoryMapper<Category>,
        private val exceptionHandler: ExceptionHandler
    ): CategoryInteractor {
        override suspend fun getCategoryList(): List<Category> =
            try {
                repository.getCategoryList().map { it.map(mapper) }
            }
            catch (e: Exception){
                listOf(exceptionHandler.mapExceptionToModel(e))
            }
    }
}