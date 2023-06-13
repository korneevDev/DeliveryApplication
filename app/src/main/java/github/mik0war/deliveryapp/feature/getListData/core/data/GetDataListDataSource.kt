package github.mik0war.deliveryapp.feature.getListData.core.data

interface GetDataListDataSource<T>{
    suspend fun getListData(): List<T>
}