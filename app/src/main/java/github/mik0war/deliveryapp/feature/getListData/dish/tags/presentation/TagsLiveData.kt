package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ObserveLiveData
import github.mik0war.deliveryapp.entity.tag.Tag
import javax.inject.Inject

interface TagsLiveData : ObserveLiveData<List<Tag>>, GetList<Tag> {
    fun updateTagsList(tagsList: List<Tag>)

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

    }
}