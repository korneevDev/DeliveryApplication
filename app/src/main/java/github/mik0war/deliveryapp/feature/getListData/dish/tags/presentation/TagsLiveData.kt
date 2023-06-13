package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ObserveLiveData
import github.mik0war.deliveryapp.feature.getListData.dish.tags.Tag
import javax.inject.Inject

interface TagsLiveData : ObserveLiveData<List<Tag>>, GetList<Tag> {
    fun updateTagsList(tagsList: List<Tag>)
    fun changeTagState(tag: Tag, isSelected: Boolean)
    fun getSelectedTags(): List<String>

    class Base @Inject constructor() : TagsLiveData {
        private val tagList = MutableLiveData<List<Tag>>()
        private var diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(TagsDiffUtilCallBack(
            this.tagList.value ?: emptyList(),
            emptyList()
        ))

        override fun observe(owner: LifecycleOwner, observer: Observer<List<Tag>>) {
            tagList.observe(owner, observer)
        }

        override fun getList(): List<Tag> = tagList.value ?: emptyList()

        override fun getDiffUtilResult(): DiffUtil.DiffResult = diffResult

        override fun updateTagsList(tagsList: List<Tag>) {
            val callBack = TagsDiffUtilCallBack(
                this.tagList.value ?: emptyList(),
                tagsList
            )
            diffResult = DiffUtil.calculateDiff(callBack)
            tagList.value = tagsList
        }

        override fun changeTagState(tag: Tag, isSelected: Boolean) {
            tagList.value?.get(tagList.value?.indexOf(tag) ?: 0)?.isSelected = isSelected
        }

        override fun getSelectedTags(): List<String> {
            val list = mutableListOf<String>()
            tagList.value?.forEach{
                if(it.isSelected)
                    list.add(it.name)
            }

            return list.toList()
        }

    }
}