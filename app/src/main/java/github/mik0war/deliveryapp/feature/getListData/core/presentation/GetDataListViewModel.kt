package github.mik0war.deliveryapp.feature.getListData.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.di.MainDispatcher
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface GetDataListViewModel<T> : ObserveLiveData<List<T>>, GetList<T> {
    fun getDataList(tags: List<String> = emptyList()): Job

    class Base<S : Entity, R : UIEntity<R>> @Inject constructor(
        private val interactor: GetDataListInteractor<S>,
        private val liveData: GetDataListLiveData<R>,
        private val mapper: DataMapper<S, R>,
        @MainDispatcher private val dispatcher: CoroutineDispatcher
    ) : ViewModel(), GetDataListViewModel<R> {
        override fun getDataList(tags: List<String>) =
            viewModelScope.launch(dispatcher) {
                liveData.updateLivaData(interactor.getDataList(tags).map { mapper.map(it) })
            }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<R>>) {
            liveData.observe(owner, observer)
        }

        override fun getList() = liveData.getList()

        override fun getDiffUtilResult() = liveData.getDiffUtilResult()
    }

}