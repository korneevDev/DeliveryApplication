package github.mik0war.deliveryapp.feature.internetData.core.data

import github.mik0war.deliveryapp.feature.internetData.category.di.core.IODispatcher
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InternetDataRepositoryImpl<T> @Inject constructor(
    private val cloudDataSource: CloudDataSource<T>,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : InternetDataRepository<T> {
    override suspend fun getCategoryList(): List<T> =
        withContext(dispatcher) {
            try {
                return@withContext cloudDataSource.getCategories()
            } catch (e: Exception) {
                throw e
            }
        }
}