package github.mik0war.deliveryapp.feature.category.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.core.GetList
import github.mik0war.deliveryapp.feature.category.di.core.MainDispatcher
import github.mik0war.deliveryapp.feature.category.domain.CategoryInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface CategoryViewModel : ObserveLiveData<List<CategoryUIModel>>, GetList<CategoryUIModel> {
    fun getCategoryList(): Job

    class Base @Inject constructor(
        private val interactor: CategoryInteractor,
        private val liveData: CategoryLiveData,
        private val mapperToUIModel: CategoryMapper<CategoryUIModel>,
        @MainDispatcher private val dispatcher: CoroutineDispatcher
    ): ViewModel(), CategoryViewModel {
        override fun getCategoryList() =
            viewModelScope.launch(dispatcher) {
                liveData.updateLivaData(interactor.getCategoryList().map { it.map(mapperToUIModel) })
            }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<CategoryUIModel>>) {
            liveData.observe(owner, observer)
        }

        override fun getList() = liveData.getList()

        override fun getDiffUtilResult() = liveData.getDiffUtilResult()
    }

}