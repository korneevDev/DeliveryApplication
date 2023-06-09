package github.mik0war.deliveryapp.feature.category.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.feature.category.core.GetList
import javax.inject.Inject

interface CategoryLiveData :ObserveLiveData<List<CategoryUIModel>>, GetList<CategoryUIModel> {
    fun updateLivaData(categoryList: List<CategoryUIModel>)

    class Base @Inject constructor(): CategoryLiveData {
        private val categoryList = MutableLiveData<List<CategoryUIModel>>()
        private lateinit var diffResult: DiffUtil.DiffResult

        override fun updateLivaData(categoryList: List<CategoryUIModel>) {
            val callBack = CategoryDiffUtilCallback(
                this.categoryList.value ?: emptyList(),
                categoryList
            )
            diffResult = DiffUtil.calculateDiff(callBack)
            this.categoryList.value = categoryList
        }

        override fun observe(
            owner: LifecycleOwner, observer: Observer<List<CategoryUIModel>>
        ) {
            this.categoryList.observe(owner, observer)
        }

        override fun getList(): List<CategoryUIModel> = categoryList.value ?: emptyList()

        override fun getDiffUtilResult() = diffResult
    }
}