package github.mik0war.deliveryapp.feature.shoppingCart.show.presentation

import android.view.View
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.TransferDataGetter

class ShowShoppingCartTransferDataGetter :
    TransferDataGetter<DishCountedUIModel, Pair<DishCountedUIModel, Int>> {
    override fun getTransferData(uiModel: DishCountedUIModel, view: View) = Pair(uiModel, view.id)
}