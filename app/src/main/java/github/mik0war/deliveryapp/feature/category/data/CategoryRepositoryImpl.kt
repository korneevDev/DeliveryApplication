package github.mik0war.deliveryapp.feature.category.data

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.data.cloud.CloudDataSource
import github.mik0war.deliveryapp.feature.category.di.core.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import github.mik0war.deliveryapp.feature.category.domain.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val cloudDataSource: CloudDataSource,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : CategoryRepository {
    override suspend fun getCategoryList(): List<CategoryDataModel> =
        withContext(dispatcher) {
            try {
                return@withContext cloudDataSource.getCategories()
            } catch (e: Exception) {
                throw e
            }
        }
}