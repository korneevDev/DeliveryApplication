package github.mik0war.dish.tags.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.dish.tags.domain.TagInteractor
import github.mik0war.entity.UIEntity
import github.mik0war.entity.dataModel.tag.Tag
import github.mik0war.entity.dataModel.tag.TagState
import github.mik0war.recycler_list.presentation.GetList
import github.mik0war.recycler_list.presentation.ObserveLiveData
import javax.inject.Inject

interface TagsViewModel<T>: ObserveLiveData<List<Tag>>,
    GetList<Tag> {
    fun setTagsList(list: List<UIEntity<T>>)
    fun updateTag(tag: Tag, newState: TagState)
    fun getSelectedTags(): List<String>


    class Base<T> @Inject constructor(
        private val interactor: TagInteractor<T>,
        private val liveData: TagsLiveData
    ): ViewModel(), TagsViewModel<T> {
        override fun setTagsList(list: List<UIEntity<T>>) {
            liveData.updateTagsList(interactor.getTagsList(liveData.getList(), list))
        }

        override fun updateTag(tag: Tag, newState: TagState) {
            liveData.updateTagsList(interactor.updateTag(liveData.getList(), tag, newState))
        }

        override fun getSelectedTags(): List<String> = interactor.getSelectedTags(liveData.getList())


        override fun observe(owner: LifecycleOwner, observer: Observer<List<Tag>>) {
            liveData.observe(owner, observer)
        }

        override fun getList(): List<Tag> = liveData.getList()

        override fun getDiffUtilResult(): DiffUtil.DiffResult = liveData.getDiffUtilResult()
    }
}