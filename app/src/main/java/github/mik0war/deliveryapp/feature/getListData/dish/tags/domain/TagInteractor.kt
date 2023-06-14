package github.mik0war.deliveryapp.feature.getListData.dish.tags.domain

import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.entity.tag.Tag
import github.mik0war.deliveryapp.entity.tag.TagState
import javax.inject.Inject

interface TagInteractor<T> {
    fun getTagsList(oldTagsList: List<Tag>, list: List<UIEntity<T>>): List<Tag>
    fun updateTag(tagsList: List<Tag>, tag: Tag, newState: TagState): List<Tag>
    fun getSelectedTags(list: List<Tag>): List<String>

    class Base<T> @Inject constructor() : TagInteractor<T> {


        override fun getTagsList(oldTagsList: List<Tag>, list: List<UIEntity<T>>): List<Tag> {
            val tagsNamesList = getTagsNameDistinct(list)
            val tags = mutableListOf<Tag>()
            if (oldTagsList.isEmpty()) {
                tagsNamesList.forEach {
                    tags.add(it.setUpTags(getMainTagsNames(tagsNamesList, list)))
                }
            } else {
                oldTagsList.forEach {
                    tags.add(
                        it.updateTag(
                            tagsNamesList,
                            areCommonSelectedInList(oldTagsList),
                            areSuperSelectedInList(oldTagsList)
                        )
                    )
                }
            }

            tags.sortBy {
                it.getTagName()
            }

            return tags.toList()
        }

        private fun areCommonSelectedInList(list: List<Tag>): Boolean {
            list.forEach {
                if (it is Tag.Selected && it !is Tag.MainSelected)
                    return true
            }
            return false
        }

        private fun areSuperSelectedInList(list: List<Tag>): Boolean {
            list.forEach {
                if (it is Tag.MainSuperSelected)
                    return true
            }
            return false
        }

        private fun getTagsNameDistinct(list: List<UIEntity<T>>): List<String> {
            val set = hashSetOf<String>()

            list.forEach { uiEntity ->
                set.addAll(uiEntity.getTagsList())
            }
            return set.toList()
        }

        private fun getMainTagsNames(
            tagsList: List<String>,
            list: List<UIEntity<T>>
        ): List<String> {
            val mutableList = tagsList.toMutableList()

            tagsList.forEach { string ->
                list.forEach {
                    if (!it.getTagsList().contains(string))
                        mutableList.remove(string)
                }
            }

            return mutableList.toList()
        }

        override fun updateTag(tagsList: List<Tag>, tag: Tag, newState: TagState): List<Tag> {
            val mutableList = tagsList.toMutableList()
            mutableList.remove(tag)

            when (newState) {
                TagState.SELECTED -> {
                    mutableList.add(
                        if (tag is Tag.MainCommon)
                            Tag.MainSuperSelected(tag.getTagName())
                        else Tag.Selected(tag.getTagName())
                    )
                }

                TagState.COMMON -> {
                    mutableList.add(
                        if (tag is Tag.MainSelected)
                            Tag.MainCommon(tag.getTagName())
                        else Tag.Common(tag.getTagName())
                    )
                }
            }

            mutableList.sortBy {
                it.getTagName()
            }

            return mutableList.toList()
        }

        override fun getSelectedTags(list: List<Tag>): List<String> {
            val selectedTags = mutableListOf<String>()
            list.forEach {
                if(it is Tag.MainSuperSelected)
                    return listOf(it.getTagName())
                if (it is Tag.Selected)
                    selectedTags.add(it.getTagName())
            }
            return selectedTags.toList()
        }
    }
}

private fun Tag.updateTag(
    tagsNamesList: List<String>,
    areCommonSelectedInList: Boolean,
    areSuperSelected: Boolean
): Tag {
    if (this is Tag.MainCommon || this is Tag.MainSelected)
        return if (!areCommonSelectedInList || this is Tag.MainSuperSelected)
            Tag.MainSelected(this.getTagName())
        else
            Tag.MainCommon(this.getTagName())

    if (areSuperSelected)
        return Tag.Common(this.getTagName())

    if (!tagsNamesList.contains(this.getTagName()))
        return Tag.Unreachable(this.getTagName())

    if (this is Tag.Unreachable)
        return Tag.Common(this.getTagName())

    return this
}

private fun String.setUpTags(mainTagsNames: List<String>): Tag =
    if (this in mainTagsNames)
        Tag.MainSelected(this)
    else
        Tag.Common(this)
