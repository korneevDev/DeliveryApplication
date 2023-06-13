package github.mik0war.deliveryapp.feature.getListData.core.presentation

import android.view.View
import github.mik0war.deliveryapp.entity.UIEntity

interface TransferDataGetter<S: UIEntity<S>, R> {
    fun getTransferData(uiModel: S, view: View): R
}
