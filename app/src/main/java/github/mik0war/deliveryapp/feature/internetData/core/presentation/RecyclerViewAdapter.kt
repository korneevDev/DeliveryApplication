package github.mik0war.deliveryapp.feature.internetData.core.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.UIEntity

abstract class RecyclerViewAdapter<T: UIEntity<T>>(
    private val internetDataLiveData: GetList<T>,
    private val imageLoader: ImageLoader,
//    private val onClickListener: (name: String) -> Unit,
    private val recycleButtonListener: () -> Unit
) : RecyclerView.Adapter<ViewHolder<T>>() {

    fun update() {
        val diffResult = internetDataLiveData.getDiffUtilResult()
        diffResult.dispatchUpdatesTo(this)
    }

    protected abstract fun errorClass(model: T): Boolean
    protected abstract fun getSuccessLayout(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val emptyList = viewType == 0
        val layout = if (emptyList)
            R.layout.empty_list_object
        else
            getSuccessLayout()

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return if (emptyList)
            ViewHolder.Error(view, recycleButtonListener)
        else ViewHolder.Success(imageLoader, view)
    }

    override fun getItemCount() = internetDataLiveData.getList().size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(internetDataLiveData.getList()[position])
    }

    override fun getItemViewType(position: Int) =
        if(errorClass(internetDataLiveData.getList()[position])) 0 else 1
}

abstract class ViewHolder<T: UIEntity<T>>(
    view: View
) : RecyclerView.ViewHolder(view) {
    private val nameView: CustomTextView =
        itemView.findViewById(R.id.categoryName)

    open fun bind(uiModel: T): Unit =
        uiModel.show(nameView)


    class Success<T: UIEntity<T>>(
        private val imageLoader: ImageLoader,
        view: View
    ) : ViewHolder<T>(view) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageHolder)
        override fun bind(uiModel: T) {
            super.bind(uiModel)
            imageLoader.loadImage(uiModel.getImageUrl(), imageView)
        }
    }

    class Error<T: UIEntity<T>>(view: View,
                                private val reloadListener: () -> Unit
    ) : ViewHolder<T>(view) {
        private val reloadButton = itemView.findViewById<Button>(R.id.reloadButton)
        override fun bind(uiModel: T) {
            super.bind(uiModel)

            reloadButton.setOnClickListener {
                reloadListener.invoke()
            }
        }
    }
}