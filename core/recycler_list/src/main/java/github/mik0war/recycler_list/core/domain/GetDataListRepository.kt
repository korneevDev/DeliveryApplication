package github.mik0war.recycler_list.core.domain

interface GetDataListRepository<T>{
    suspend fun getCategoryList(): List<T>
}