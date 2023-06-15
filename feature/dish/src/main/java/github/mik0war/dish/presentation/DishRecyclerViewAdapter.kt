package github.mik0war.dish.presentation

import androidx.constraintlayout.widget.ConstraintLayout
import github.mik0war.dish.R
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.recycler_list.presentation.GetList
import github.mik0war.recycler_list.presentation.ImageLoader
import github.mik0war.recycler_list.presentation.RecyclerViewAdapter

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