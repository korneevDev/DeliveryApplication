package github.mik0war.deliveryapp.entity

import github.mik0war.deliveryapp.entity.mapper.Mapper

interface Entity {
    fun<R: Mapper<T>, T> map(mapper: R): T
}

interface UIEntity<T> : Entity {
    fun equalsId(other: T): Boolean
    fun getImageUrl(): String

    fun show(nameView: CustomTextView)
}