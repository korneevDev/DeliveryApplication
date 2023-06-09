package github.mik0war.deliveryapp.feature.category.presentation

import androidx.recyclerview.widget.DiffUtil

class CategoryDiffUtilCallback(
    private val oldList: List<CategoryUIModel>,
    private val newList: List<CategoryUIModel>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
        = oldList[oldItemPosition].equalsId(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
        = oldList[oldItemPosition] == newList[newItemPosition]
}