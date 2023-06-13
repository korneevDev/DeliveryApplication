package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import androidx.recyclerview.widget.DiffUtil
import github.mik0war.deliveryapp.feature.getListData.dish.tags.Tag

class TagsDiffUtilCallBack(
    private val oldList: List<Tag>,
    private val newList: List<Tag>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == (newList[newItemPosition]).name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}