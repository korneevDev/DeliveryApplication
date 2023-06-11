package github.mik0war.deliveryapp.feature.internetData.category.presentation

import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.GetList
import github.mik0war.deliveryapp.feature.internetData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.internetData.core.presentation.RecyclerViewAdapter

class CategoryRecyclerViewAdapter(
    internetDataLiveData: GetList<CategoryUIModel>,
    imageLoader: ImageLoader,
    recycleButtonListener: () -> Unit
) : RecyclerViewAdapter<CategoryUIModel>(internetDataLiveData, imageLoader, recycleButtonListener) {
    override fun errorClass(model: CategoryUIModel) = model is CategoryUIModel.Error
    override fun getSuccessLayout() = R.layout.category_object
}