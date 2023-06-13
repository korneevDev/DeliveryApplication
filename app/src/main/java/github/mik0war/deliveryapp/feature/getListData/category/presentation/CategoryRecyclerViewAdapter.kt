package github.mik0war.deliveryapp.feature.getListData.category.presentation

import androidx.constraintlayout.widget.ConstraintLayout
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.getListData.core.presentation.RecyclerViewAdapter

class CategoryRecyclerViewAdapter(
    internetDataLiveData: GetList<CategoryUIModel>,
    imageLoader: ImageLoader,
    transferDataGetter: CategoryTransferDataGetter
) : RecyclerViewAdapter<CategoryUIModel, String, ConstraintLayout>(
    internetDataLiveData,
    imageLoader,
    transferDataGetter
) {
    override fun errorClass(model: CategoryUIModel) = model is CategoryUIModel.Error
    override fun getSuccessLayout() = R.layout.category_object
    override fun getClickableId() = R.id.objectLayout
}