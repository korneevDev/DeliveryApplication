package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.internetData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.internetData.core.presentation.RecyclerViewAdapter

class DishRecyclerViewAdapter(
    internetDataLiveData: GetList<DishUIModel>,
    imageLoader: ImageLoader,
    transferDataGetter: DishTransferDataGetter
) : RecyclerViewAdapter<DishUIModel, DishUIModel>(
    internetDataLiveData,
    imageLoader,
    transferDataGetter) {
    override fun errorClass(model: DishUIModel) = model is DishUIModel.Error
    override fun getSuccessLayout() = R.layout.dish_object
}