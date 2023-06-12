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

abstract class RecyclerViewAdapter<T: UIEntity<T>, E>(
    private val internetDataLiveData: GetList<T>,
    private val imageLoader: ImageLoader,
    private val transferDataGetter: TransferDataGetter<T, E>
) : RecyclerView.Adapter<ViewHolder<T>>() {

    var onSuccessClickListener: (name: E) -> Unit = {}
    var onErrorClickListener: () -> Unit = {}
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
        else ViewHolder.Success(imageLoader, view, onSuccessClickListener, transferDataGetter)
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
        itemView.findViewById(R.id.objectName)
    protected val `object`: ConstraintLayout = itemView.findViewById(R.id.objectLayout)
    open fun bind(uiModel: T){
        uiModel.show(nameView)
    }


    class Success<T: UIEntity<T>, E>(
        private val imageLoader: ImageLoader,
        view: View,
        private val onClickListener: (name: E) -> Unit,
        private val transferDataGetter: TransferDataGetter<T, E>
    ) : ViewHolder<T>(view) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageHolder)
        override fun bind(uiModel: T) {
            super.bind(uiModel)
            imageLoader.loadImage(uiModel.getUrl(), imageView)

            `object`.setOnClickListener{
                onClickListener.invoke(transferDataGetter.getTransferData(uiModel))
            }
        }
    }

    class Error<T: UIEntity<T>>(
        view: View,
        private val reloadListener: () -> Unit
    ) : ViewHolder<T>(view){
        override fun bind(uiModel: T) {
            super.bind(uiModel)
            `object`.setOnClickListener{
                reloadListener.invoke()
            }
        }
    }
}