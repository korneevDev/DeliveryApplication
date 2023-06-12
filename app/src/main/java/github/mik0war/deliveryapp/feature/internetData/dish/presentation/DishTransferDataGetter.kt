package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.TransferDataGetter

class DishTransferDataGetter : TransferDataGetter<DishUIModel, DishUIModel> {
    override fun getTransferData(uiModel: DishUIModel) = uiModel
}