package github.mik0war.show_cart_list.data

import github.mik0war.database.GetDishDAO
import github.mik0war.database.DishCacheModel
import github.mik0war.entity.DataMapper
import github.mik0war.entity.Entity
import github.mik0war.entity.NoCachedDishesException
import github.mik0war.recycler_list.data.GetDataListDataSource
import javax.inject.Inject

interface CacheGetDataListDataSource<T> :
    GetDataListDataSource<T> {

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