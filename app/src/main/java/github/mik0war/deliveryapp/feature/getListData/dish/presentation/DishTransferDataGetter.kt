package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import android.view.View
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.recycler_list.presentation.TransferDataGetter

class DishTransferDataGetter :
    TransferDataGetter<DishUIModel, DishUIModel> {
    override fun getTransferData(uiModel: DishUIModel, view: View): DishUIModel = uiModel
}