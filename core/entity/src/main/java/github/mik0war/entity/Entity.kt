package github.mik0war.entity

import github.mik0war.entity.dataModel.mapper.MapperTo

interface Entity {
    fun<R: MapperTo<T>, T> map(mapper: R): T
    fun getTagsForFilter(): List<String>
}

interface UIEntity<T> : Entity {
    fun equalsId(other: T): Boolean
    fun getUrl(): String
    fun getCurrentName(): String
    fun getTagsList(): List<String>

    fun show(nameView: CustomTextView)
}