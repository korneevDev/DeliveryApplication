package github.mik0war.deliveryapp.feature.shoppingCart.show.data

import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.NoCachedDishesException
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.core.GetDishDAO
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel
import javax.inject.Inject

interface CacheGetDataListDataSource<T> : GetDataListDataSource<T> {

    class Base<R: Entity> @Inject constructor(
        private val showDishDAO: GetDishDAO,
        private val mapper: DataMapper<DishCacheModel, R>
    ): CacheGetDataListDataSource<R> {
        override suspend fun getListData(): List<R> {
            val list = showDishDAO.getDishList()
            return if(list.isEmpty())
                throw NoCachedDishesException()
            else
                list.map { mapper.map(it)}
        }
    }
}