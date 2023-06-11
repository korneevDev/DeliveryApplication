package github.mik0war.deliveryapp.feature.internetData.core.data

import github.mik0war.deliveryapp.entity.NoConnectionException
import github.mik0war.deliveryapp.entity.ServiceUnavailableException
import java.net.UnknownHostException

interface CloudDataSource<T>{
    suspend fun getCategories(): List<T>

    abstract class Base<T> : CloudDataSource<T> {
        abstract suspend fun getDataFromCloud(): List<T>
        override suspend fun getCategories(): List<T> =
            try {
                getDataFromCloud()
            } catch (e: Exception) {
                throw if (e is UnknownHostException)
                    NoConnectionException()
                else ServiceUnavailableException()
            }
    }
}


