package github.mik0war.deliveryapp.feature.internetData.core.presentation

import github.mik0war.deliveryapp.entity.UIEntity

interface TransferDataGetter<S: UIEntity<S>, R> {
    fun getTransferData(uiModel: S): R
}
