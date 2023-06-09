package github.mik0war.deliveryapp.feature.category.core

import androidx.recyclerview.widget.DiffUtil

interface GetList<T> {
    fun getList(): List<T>

    fun getDiffUtilResult(): DiffUtil.DiffResult
}