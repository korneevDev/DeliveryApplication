package github.mik0war.deliveryapp.feature.category.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.feature.category.core.GetList

class RecyclerViewAdapter(
    private val categoryLiveData: GetList<CategoryUIModel>
) : RecyclerView.Adapter<ViewHolder>() {

    fun update() {
        val diffResult = categoryLiveData.getDiffUtilResult()
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val emptyList = viewType == 0

        val layout = if (emptyList)
            R.layout.empty_list_object
        else
            R.layout.category_object

        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun getItemCount() = categoryLiveData.getList().size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryLiveData.getList()[position])
    }

    override fun getItemViewType(position: Int) =
        when (categoryLiveData.getList()[position]) {
            is CategoryUIModel.Error -> 0
            else -> 1
        }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameView = itemView.findViewById<CustomTextView>(R.id.categoryName)
    private val imageView = itemView.findViewById<CustomTextView>(R.id.imageName)
    fun bind(categoryUIModel: CategoryUIModel) {
        categoryUIModel.map(MapperToUI(nameView, imageView))
    }

}