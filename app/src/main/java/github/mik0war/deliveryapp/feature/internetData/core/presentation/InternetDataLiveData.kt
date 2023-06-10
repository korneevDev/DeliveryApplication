package github.mik0war.deliveryapp.feature.internetData.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.feature.internetData.core.core.UIEntity
import javax.inject.Inject

interface InternetDataLiveData<T: UIEntity<T>> : ObserveLiveData<List<T>>, GetList<T> {
    fun updateLivaData(categoryList: List<T>)

    class Base<T: UIEntity<T>> @Inject constructor(): InternetDataLiveData<T> {
        private val dataList = MutableLiveData<List<T>>()
        private lateinit var diffResult: DiffUtil.DiffResult

        override fun updateLivaData(categoryList: List<T>) {
            val callBack = InternetDataDiffUtilCallback(
                this.dataList.value ?: emptyList(),
                categoryList
            )
            diffResult = DiffUtil.calculateDiff(callBack)
            this.dataList.value = categoryList
        }

        override fun observe(
            owner: LifecycleOwner, observer: Observer<List<T>>
        ) {
            this.dataList.observe(owner, observer)
        }

        override fun getList(): List<T> = dataList.value ?: emptyList()

        override fun getDiffUtilResult() = diffResult
    }
}