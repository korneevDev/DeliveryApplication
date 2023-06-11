package github.mik0war.deliveryapp.feature.internetData.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.InternetDataMapper
import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.di.MainDispatcher
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface InternetDataViewModel<T> : ObserveLiveData<List<T>>, GetList<T> {
    fun getCategoryList(): Job

    class Base<S: Entity, R: UIEntity<R>> @Inject constructor(
        private val interactor: InternetDataInteractor<S>,
        private val liveData: InternetDataLiveData<R>,
        private val mapper: InternetDataMapper<S, R>,
        @MainDispatcher private val dispatcher: CoroutineDispatcher
    ): ViewModel(), InternetDataViewModel<R> {
        override fun getCategoryList() =
            viewModelScope.launch(dispatcher) {
                liveData.updateLivaData(interactor.getDataList().map { mapper.map(it) })
            }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<R>>) {
            liveData.observe(owner, observer)
        }

        override fun getList() = liveData.getList()

        override fun getDiffUtilResult() = liveData.getDiffUtilResult()
    }

}