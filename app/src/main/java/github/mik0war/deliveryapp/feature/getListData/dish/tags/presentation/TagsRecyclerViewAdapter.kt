package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.entity.ColorResourceProvider
import github.mik0war.entity.CustomTextView
import github.mik0war.entity.dataModel.tag.Tag
import github.mik0war.entity.dataModel.tag.TagState
import github.mik0war.recycler_list.presentation.GetList

class TagsRecyclerViewAdapter(
    private val getList: GetList<Tag>,
    private val colorResourceProvider: ColorResourceProvider,
    private val onChangeClickListener: (tag: Tag, state: TagState) -> Unit
) : RecyclerView.Adapter<TagViewHolder>() {

    fun update() {
        val diffResult = getList.getDiffUtilResult()
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.tag_object, parent, false
        )
        return when (viewType) {
            0 -> TagViewHolder.Selected(colorResourceProvider, onChangeClickListener, view)
            1 -> TagViewHolder.Common(colorResourceProvider, onChangeClickListener, view)
            2 -> TagViewHolder.Unreachable(colorResourceProvider, view)
            else -> throw IllegalStateException()
        }
    }

    override fun getItemCount(): Int = getList.getList().size

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(getList.getList()[position])
    }

    override fun getItemViewType(position: Int): Int =
        when (getList.getList()[position]) {
            is Tag.Selected -> 0
            is Tag.Common -> 1
            is Tag.Unreachable -> 2
        }
}

sealed class TagViewHolder(
    private val onClickListener: (tag: Tag, state: TagState) -> Unit = { _, _ -> },
    view: View
) : RecyclerView.ViewHolder(view) {
    private val nameView: CustomTextView = itemView.findViewById(R.id.objectName)
    open fun bind(tag: Tag) {
        nameView.set(tag.getTagName())
        nameView.setOnClickListener {
            onClickListener.invoke(tag, getNewState())
        }
        nameView.backgroundTintList =
            ColorStateList.valueOf(getColor())
        nameView.setTextColor(getTextColor())
    }

    protected abstract fun getColor(): Int
    protected abstract fun getTextColor(): Int
    protected abstract fun getNewState(): TagState

    class Selected(
        private val colorResourceProvider: ColorResourceProvider,
        onClickListener: (tag: Tag, state: TagState) -> Unit,
        view: View
    ) : TagViewHolder(onClickListener, view) {
        override fun getColor() = colorResourceProvider.getColor(R.color.selected_blue)
        override fun getTextColor() = colorResourceProvider.getColor(R.color.white)
        override fun getNewState(): TagState = TagState.COMMON
    }

    class Common(
        private val colorResourceProvider: ColorResourceProvider,
        onClickListener: (tag: Tag, state: TagState) -> Unit,
        view: View
    ) : TagViewHolder(onClickListener, view) {
        override fun getColor() = colorResourceProvider.getColor(R.color.light_gray_background)
        override fun getTextColor() = colorResourceProvider.getColor(R.color.black)
        override fun getNewState() = TagState.SELECTED
    }

    class Unreachable(
        private val colorResourceProvider: ColorResourceProvider,
        view: View
    ) : TagViewHolder(view=view) {
        override fun getColor() = colorResourceProvider.getColor(R.color.light_gray_background)
        override fun getTextColor() = colorResourceProvider.getColor(R.color.black_transparent_65)
        override fun getNewState() = TagState.COMMON
    }
}
