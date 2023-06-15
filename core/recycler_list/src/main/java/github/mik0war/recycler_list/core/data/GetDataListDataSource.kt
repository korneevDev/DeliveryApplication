package github.mik0war.recycler_list.core.data

interface GetDataListDataSource<T>{
    suspend fun getListData(): List<T>
}