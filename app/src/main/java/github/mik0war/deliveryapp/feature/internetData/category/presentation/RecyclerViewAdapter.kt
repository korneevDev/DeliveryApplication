package github.mik0war.deliveryapp.feature.internetData.category.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.feature.internetData.core.presentation.CustomTextView
import github.mik0war.deliveryapp.feature.internetData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.internetData.core.presentation.ImageLoader

class RecyclerViewAdapter(
    private val categoryLiveData: GetList<CategoryUIModel>,
    private val imageLoader: ImageLoader,
    private val recycleButtonListener: () -> Unit
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

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return if (emptyList)
            ViewHolder.Error(view, recycleButtonListener)
        else ViewHolder.Success(imageLoader, view)
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

abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameView: CustomTextView =
        itemView.findViewById(R.id.categoryName)

    open fun bind(categoryUIModel: CategoryUIModel) {
        categoryUIModel.map(MapperToUI(nameView))
    }

    class Success(
        private val imageLoader: ImageLoader,
        view: View
    ) : ViewHolder(view) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageHolder)
        override fun bind(categoryUIModel: CategoryUIModel) {
            super.bind(categoryUIModel)
            if (categoryUIModel is CategoryUIModel.Success && categoryUIModel.getURL().isNotEmpty())
                imageLoader.loadImage(categoryUIModel.getURL(), imageView)
        }
    }

    class Error(view: View,
        private val reloadListener: () -> Unit
    ) : ViewHolder(view) {
        private val reloadButton = itemView.findViewById<Button>(R.id.reloadButton)
        override fun bind(categoryUIModel: CategoryUIModel) {
            super.bind(categoryUIModel)

            reloadButton.setOnClickListener {
                reloadListener.invoke()
            }
        }
    }
}