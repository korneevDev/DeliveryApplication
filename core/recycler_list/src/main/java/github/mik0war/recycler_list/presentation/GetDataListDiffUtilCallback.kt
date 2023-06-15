package github.mik0war.recycler_list.presentation

import androidx.recyclerview.widget.DiffUtil
import github.mik0war.entity.UIEntity

class GetDataListDiffUtilCallback<T: UIEntity<T>>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
        = oldList[oldItemPosition].equalsId(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
        = oldList[oldItemPosition] == newList[newItemPosition]
}