package github.mik0war.show_cart_list.presentation

import android.view.View
import android.widget.ImageButton
import github.mik0war.entity.CustomTextView
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel
import github.mik0war.recycler_list.presentation.GetList
import github.mik0war.recycler_list.presentation.ImageLoader
import github.mik0war.recycler_list.presentation.RecyclerViewAdapter
import github.mik0war.recycler_list.presentation.TransferDataGetter
import github.mik0war.recycler_list.presentation.ViewHolder
import github.mik0war.show_cart_list.R
import github.mik0war.recycler_list.R as R_list


class ShowShoppingCartRecyclerViewAdapter(
    internetDataLiveData: GetList<DishCountedUIModel>,
    imageLoader: ImageLoader,
    transferDataGetter: ShowShoppingCartTransferDataGetter,
    private val resourceProvider: StringResourceProvider
) : RecyclerViewAdapter<DishCountedUIModel, Pair<DishCountedUIModel, Int>, ImageButton>(
    internetDataLiveData,
    imageLoader,
    transferDataGetter
) {
    override fun errorClass(model: DishCountedUIModel) = model is DishCountedUIModel.Error
    override fun getSuccessLayout() = R.layout.cart_object_layout
    override fun getClickableId(): Int = R.id.incrementButton
    private val secondButtonId: Int = R.id.decrementButton

    override fun buildSuccessViewHolder(
        imageLoader: ImageLoader,
        buttonId: Int,
        view: View,
        onClickListener: (name: Pair<DishCountedUIModel, Int>) -> Unit,
        transferDataGetter: TransferDataGetter<DishCountedUIModel, Pair<DishCountedUIModel, Int>>
    ): ViewHolder.Success<DishCountedUIModel, Pair<DishCountedUIModel, Int>, ImageButton> {
        return ShoppingViewHolder(
            imageLoader,
            buttonId,
            view,
            onClickListener,
            transferDataGetter,
            secondButtonId,
            resourceProvider
        )
    }
}

class ShoppingViewHolder(
    imageLoader: ImageLoader,
    buttonId: Int,
    view: View,
    onClickListener: (name: Pair<DishCountedUIModel, Int>) -> Unit,
    transferDataGetter: TransferDataGetter<DishCountedUIModel, Pair<DishCountedUIModel, Int>>,
    secondButtonId: Int,
    private val stringResourceProvider: StringResourceProvider
) : ViewHolder.Success<DishCountedUIModel, Pair<DishCountedUIModel, Int>, ImageButton>(
    imageLoader, buttonId, view, onClickListener, transferDataGetter

) {
    private val secondButton = itemView.findViewById<ImageButton>(secondButtonId)

    private val nameView: CustomTextView = itemView.findViewById(R_list.id.objectName)
    private val priceView: CustomTextView = itemView.findViewById(R.id.priceView)
    private val weightView: CustomTextView = itemView.findViewById(R.id.weightView)
    private val countView: CustomTextView = itemView.findViewById(R.id.countView)

    override fun bind(uiModel: DishCountedUIModel) {
        super.bind(uiModel)
        setOnObjectClickListener(secondButton, uiModel)

        uiModel.show(
            nameView, priceView, weightView, countView,
            weightMeasure = stringResourceProvider.getString(R_list.string.weight_measure),
            priceAddition = stringResourceProvider.getString(R_list.string.price_addition),
            weightPrefix = stringResourceProvider.getString(R_list.string.weight_prefix)
        )

    }
}
