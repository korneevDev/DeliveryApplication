package github.mik0war.deliveryapp.feature.shoppingCart.fill.data

import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.CacheDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.fill.domain.FillCartRepository
import github.mik0war.entity.DataMapper
import github.mik0war.entity.Entity
import github.mik0war.entity.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FillCartRepositoryImpl<S: Entity, R: Entity> @Inject constructor(
    private val cacheDataSource: CacheDataSource<R>,
    private val mapper: DataMapper<S, R>,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : FillCartRepository<S>{
    override suspend fun saveDish(dish: S, count: Int) = withContext(dispatcher){
        cacheDataSource.changeDishCount(mapper.map(dish), count)
    }

    override suspend fun clearTable() = withContext(dispatcher){
        cacheDataSource.clearTable()
    }
}