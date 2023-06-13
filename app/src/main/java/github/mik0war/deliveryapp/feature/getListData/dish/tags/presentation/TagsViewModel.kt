package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ObserveLiveData
import github.mik0war.deliveryapp.feature.getListData.dish.tags.Tag
import github.mik0war.deliveryapp.feature.getListData.dish.tags.domain.TagInteractor
import javax.inject.Inject

interface TagsViewModel<T>: ObserveLiveData<List<Tag>>, GetList<Tag> {
    fun setTagsList(tagsList: List<Tag>)
    fun updateTagsList(list: List<UIEntity<T>>): List<Tag>
    fun getSelectedTags(): List<String>


    class Base<T> @Inject constructor(
        private val interactor: TagInteractor<T>,
        private val liveData: TagsLiveData
    ): ViewModel(), TagsViewModel<T> {
        override fun setTagsList(tagsList: List<Tag>) {
            liveData.updateTagsList(tagsList)
        }

        override fun getSelectedTags(): List<String> = liveData.getSelectedTags()

        override fun updateTagsList(list: List<UIEntity<T>>) =
            interactor.getTagsList(list)

        override fun observe(owner: LifecycleOwner, observer: Observer<List<Tag>>) {
            liveData.observe(owner, observer)
        }

        override fun getList(): List<Tag> = liveData.getList()

        override fun getDiffUtilResult(): DiffUtil.DiffResult = liveData.getDiffUtilResult()
    }
}