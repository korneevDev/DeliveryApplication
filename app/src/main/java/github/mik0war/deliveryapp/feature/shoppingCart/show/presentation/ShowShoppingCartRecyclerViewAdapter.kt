package github.mik0war.deliveryapp.feature.shoppingCart.show.presentation

import android.view.View
import android.widget.ImageButton
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.CustomTextView
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.getListData.core.presentation.RecyclerViewAdapter
import github.mik0war.deliveryapp.feature.getListData.core.presentation.TransferDataGetter
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ViewHolder


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

    private val nameView: CustomTextView = itemView.findViewById(R.id.objectName)
    private val priceView: CustomTextView = itemView.findViewById(R.id.priceView)
    private val weightView: CustomTextView = itemView.findViewById(R.id.weightView)
    private val countView: CustomTextView = itemView.findViewById(R.id.countView)

    override fun bind(uiModel: DishCountedUIModel) {
        super.bind(uiModel)
        setOnObjectClickListener(secondButton, uiModel)

        uiModel.show(
            nameView, priceView, weightView, countView,
            weightMeasure = stringResourceProvider.getString(R.string.weight_measure),
            priceAddition = stringResourceProvider.getString(R.string.price_addition),
            weightPrefix = stringResourceProvider.getString(R.string.weight_prefix)
        )

    }
}