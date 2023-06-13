package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import androidx.constraintlayout.widget.ConstraintLayout
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.getListData.core.presentation.RecyclerViewAdapter

class DishRecyclerViewAdapter(
    internetDataLiveData: GetList<DishUIModel>,
    imageLoader: ImageLoader,
    transferDataGetter: DishTransferDataGetter
) : RecyclerViewAdapter<DishUIModel, DishUIModel, ConstraintLayout>(
    internetDataLiveData,
    imageLoader,
    transferDataGetter) {
    override fun errorClass(model: DishUIModel) = model is DishUIModel.Error
    override fun getSuccessLayout() = R.layout.dish_object
    override fun getClickableId() = R.id.objectLayout
}