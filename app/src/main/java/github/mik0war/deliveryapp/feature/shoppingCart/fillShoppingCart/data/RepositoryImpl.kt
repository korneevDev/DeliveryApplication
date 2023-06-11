package github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.data

import github.mik0war.deliveryapp.di.IODispatcher
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.data.cache.CacheDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.domain.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RepositoryImpl<S: Entity, R: Entity>(
    private val cacheDataSource: CacheDataSource<R>,
    private val mapper: DataMapper<S, R>,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : Repository<S>{
    override suspend fun saveDish(dish: S, count: Int) = withContext(dispatcher){
        cacheDataSource.changeDishCount(mapper.map(dish), count)
    }

}