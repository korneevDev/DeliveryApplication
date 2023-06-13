package github.mik0war.deliveryapp.feature.getListData.dish.tags.domain

import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.feature.getListData.dish.tags.Tag
import javax.inject.Inject

interface TagInteractor<T> {
    fun getTagsList(list: List<UIEntity<T>>): List<Tag>

    class Base<T> @Inject constructor(): TagInteractor<T> {
        override fun getTagsList(list: List<UIEntity<T>>): List<Tag> {
            val tagsNamesSet = HashSet<String>()
            list.forEach { uiModel ->
                uiModel.getTagsList().forEach {
                    tagsNamesSet.add(it)
                }
            }
            val tagsList = mutableListOf<Tag>()
            tagsNamesSet.forEach{
                tagsList.add(Tag(it, false))
            }

            return tagsList
        }
    }
}