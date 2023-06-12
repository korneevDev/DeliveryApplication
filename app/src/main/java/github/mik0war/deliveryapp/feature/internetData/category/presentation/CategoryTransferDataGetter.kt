package github.mik0war.deliveryapp.feature.internetData.category.presentation

import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.TransferDataGetter

class CategoryTransferDataGetter : TransferDataGetter<CategoryUIModel, String>{
    override fun getTransferData(uiModel: CategoryUIModel) = uiModel.getFragmentName()
}