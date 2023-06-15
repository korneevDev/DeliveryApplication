package github.mik0war.database_communication.domain

interface FillCartRepository<T> {
    suspend fun saveDish(dish: T, count: Int)

    suspend fun clearTable()
}