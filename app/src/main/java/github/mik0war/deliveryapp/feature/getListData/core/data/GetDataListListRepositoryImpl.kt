package github.mik0war.deliveryapp.feature.getListData.core.data

import github.mik0war.deliveryapp.di.IODispatcher
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDataListListRepositoryImpl<T> @Inject constructor(
    private val cloudDataSource: GetDataListDataSource<T>,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : GetDataListRepository<T> {
    override suspend fun getCategoryList(): List<T> =
        withContext(dispatcher) {
            try {
                return@withContext cloudDataSource.getListData()
            } catch (e: Exception) {
                throw e
            }
        }
}