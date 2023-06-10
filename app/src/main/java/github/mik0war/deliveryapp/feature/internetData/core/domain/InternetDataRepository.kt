package github.mik0war.deliveryapp.feature.internetData.core.domain

interface InternetDataRepository<T>{
    suspend fun getCategoryList(): List<T>
}