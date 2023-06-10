package github.mik0war.deliveryapp.feature.internetData.core.core

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper

interface Entity {
    fun <T> map(mapper: CategoryMapper<T>): T
}

interface UIEntity<T> : Entity{
    fun equalsId(other: T): Boolean
}