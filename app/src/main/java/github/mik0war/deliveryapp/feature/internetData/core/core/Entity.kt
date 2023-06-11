package github.mik0war.deliveryapp.feature.internetData.core.core

import github.mik0war.deliveryapp.feature.internetData.core.presentation.CustomTextView

interface Entity {
    fun<R, T> map(mapper: R): T
}

interface UIEntity<T> : Entity{
    fun equalsId(other: T): Boolean
    fun getImageUrl(): String

    fun show(nameView: CustomTextView)
}