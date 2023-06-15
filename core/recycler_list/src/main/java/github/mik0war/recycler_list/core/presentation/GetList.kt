package github.mik0war.recycler_list.core.presentation

import androidx.recyclerview.widget.DiffUtil

interface GetList<T> {
    fun getList(): List<T>
    fun getDiffUtilResult(): DiffUtil.DiffResult
}