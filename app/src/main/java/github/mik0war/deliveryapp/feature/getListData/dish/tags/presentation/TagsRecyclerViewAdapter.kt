package github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.ColorResourceProvider
import github.mik0war.deliveryapp.entity.CustomTextView
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.dish.tags.Tag

class TagsRecyclerViewAdapter(
    private val getList: GetList<Tag>,
    private val colorResourceProvider: ColorResourceProvider,
    private val onAddClickListener: (tag: Tag) -> Unit,
    private val onRemoveClickListener: (tag: Tag) -> Unit
) : RecyclerView.Adapter<TagViewHolder>() {

    fun update() {
        val diffResult = getList.getDiffUtilResult()
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.tag_object, parent, false)
        Log.e("kek", "holder $viewType")
        return when(viewType) {
            0 -> TagViewHolder.Selected(colorResourceProvider, onRemoveClickListener, view)
            1 -> TagViewHolder.UnSelected(colorResourceProvider, onAddClickListener, view)
            else -> throw IllegalStateException()
        }
    }

    override fun getItemCount(): Int = getList.getList().size

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(getList.getList()[position])
    }

    override fun getItemViewType(position: Int): Int =
        when(getList.getList()[position].isSelected){
            true -> 0
            false -> 1
        }
}

sealed class TagViewHolder(
    private val onClickListener: (tag: Tag) -> Unit,
    view: View
): RecyclerView.ViewHolder(view){
    private val nameView: CustomTextView = itemView.findViewById(R.id.objectName)
    open fun bind(tag: Tag){
        nameView.set(tag.name)
        nameView.setOnClickListener {
            onClickListener.invoke(tag)
        }
        nameView.backgroundTintList =
            ColorStateList.valueOf(getColor())
        nameView.setTextColor(getTextColor())
    }

    protected abstract fun getColor(): Int
    protected abstract fun getTextColor(): Int

    class Selected(
        private val colorResourceProvider: ColorResourceProvider,
        onClickListener: (tag: Tag) -> Unit,
        view: View
    ) : TagViewHolder(onClickListener, view){
        override fun getColor() = colorResourceProvider.getColor(R.color.selected_blue)
        override fun getTextColor() = colorResourceProvider.getColor(R.color.white)
    }

    class UnSelected(
        private val colorResourceProvider: ColorResourceProvider,
        onClickListener: (tag: Tag) -> Unit,
        view: View
    ) : TagViewHolder(onClickListener, view){
        override fun getColor() = colorResourceProvider.getColor(R.color.light_gray_background)
        override fun getTextColor() = colorResourceProvider.getColor(R.color.black)
    }
}
