package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import android.view.View
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.TransferDataGetter

class DishTransferDataGetter : TransferDataGetter<DishUIModel, DishUIModel> {
    override fun getTransferData(uiModel: DishUIModel, view: View): DishUIModel = uiModel
}