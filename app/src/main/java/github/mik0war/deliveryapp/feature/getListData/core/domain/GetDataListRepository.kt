package github.mik0war.deliveryapp.feature.getListData.core.domain

interface GetDataListRepository<T>{
    suspend fun getCategoryList(): List<T>
}