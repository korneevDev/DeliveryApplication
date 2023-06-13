package github.mik0war.deliveryapp.feature.getListData.core.presentation

import androidx.recyclerview.widget.DiffUtil

interface GetList<T> {
    fun getList(): List<T>
    fun getDiffUtilResult(): DiffUtil.DiffResult
}