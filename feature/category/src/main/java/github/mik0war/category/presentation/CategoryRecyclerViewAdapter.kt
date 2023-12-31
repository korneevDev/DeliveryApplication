package github.mik0war.category.presentation

import androidx.constraintlayout.widget.ConstraintLayout
import github.mik0war.category.R
import github.mik0war.entity.dataModel.category.CategoryUIModel
import github.mik0war.recycler_list.presentation.GetList
import github.mik0war.recycler_list.presentation.ImageLoader
import github.mik0war.recycler_list.presentation.RecyclerViewAdapter

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