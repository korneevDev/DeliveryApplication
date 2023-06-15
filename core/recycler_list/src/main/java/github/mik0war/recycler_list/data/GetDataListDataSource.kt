package github.mik0war.recycler_list.data

interface GetDataListDataSource<T>{
    suspend fun getListData(): List<T>
}