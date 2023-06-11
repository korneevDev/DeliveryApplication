package github.mik0war.deliveryapp.feature.internetData.core.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.CustomTextView
import github.mik0war.deliveryapp.entity.UIEntity

abstract class RecyclerViewAdapter<T: UIEntity<T>>(
    private val internetDataLiveData: GetList<T>,
    private val imageLoader: ImageLoader,
    private val onSuccessClickListener: (name: String) -> Unit,
    private val onErrorClickListener: (name: String) -> Unit
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
            ViewHolder.Error(view, onErrorClickListener)
        else ViewHolder.Success(imageLoader, view, onSuccessClickListener)
    }

    override fun getItemCount() = internetDataLiveData.getList().size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(internetDataLiveData.getList()[position])
    }

    override fun getItemViewType(position: Int) =
        if(errorClass(internetDataLiveData.getList()[position])) 0 else 1
}

abstract class ViewHolder<T: UIEntity<T>>(
    view: View,
    private val onObjectClickListener: (name: String) -> Unit
) : RecyclerView.ViewHolder(view) {
    private val nameView: CustomTextView =
        itemView.findViewById(R.id.objectName)
    private val `object`: ConstraintLayout = itemView.findViewById(R.id.objectLayout)
    open fun bind(uiModel: T){
        uiModel.show(nameView)
        `object`.setOnClickListener{
            onObjectClickListener.invoke(uiModel.getFragmentName())
        }
    }


    class Success<T: UIEntity<T>>(
        private val imageLoader: ImageLoader,
        view: View,
        onClickListener: (name: String) -> Unit
    ) : ViewHolder<T>(view, onClickListener) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageHolder)
        override fun bind(uiModel: T) {
            super.bind(uiModel)
            imageLoader.loadImage(uiModel.getUrl(), imageView)
        }
    }

    class Error<T: UIEntity<T>>(view: View,
                                reloadListener: (name: String) -> Unit
    ) : ViewHolder<T>(view, reloadListener)
}