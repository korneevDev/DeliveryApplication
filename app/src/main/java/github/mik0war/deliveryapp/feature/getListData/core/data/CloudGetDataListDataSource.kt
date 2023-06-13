package github.mik0war.deliveryapp.feature.getListData.core.data

import github.mik0war.deliveryapp.entity.NoConnectionException
import github.mik0war.deliveryapp.entity.ServiceUnavailableException
import java.net.UnknownHostException

interface CloudGetDataListDataSource<T>: GetDataListDataSource<T>{
    abstract class Base<T> : CloudGetDataListDataSource<T> {
        abstract suspend fun getDataFromCloud(): List<T>
        override suspend fun getListData(): List<T> =
            try {
                getDataFromCloud()
            } catch (e: Exception) {
                throw if (e is UnknownHostException)
                    NoConnectionException()
                else ServiceUnavailableException()
            }
    }
}


