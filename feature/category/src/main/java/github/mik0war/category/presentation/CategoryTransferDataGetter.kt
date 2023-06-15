package github.mik0war.category.presentation

import android.view.View
import github.mik0war.entity.dataModel.category.CategoryUIModel
import github.mik0war.recycler_list.presentation.TransferDataGetter

class CategoryTransferDataGetter :
    TransferDataGetter<CategoryUIModel, String> {
    override fun getTransferData(uiModel: CategoryUIModel, view: View): String = uiModel.getCurrentName()
}