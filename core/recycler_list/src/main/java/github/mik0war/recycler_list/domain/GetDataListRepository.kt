package github.mik0war.recycler_list.domain

interface GetDataListRepository<T>{
    suspend fun getCategoryList(): List<T>
}