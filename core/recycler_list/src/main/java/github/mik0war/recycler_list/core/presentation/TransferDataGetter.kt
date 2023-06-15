package github.mik0war.recycler_list.core.presentation

import android.view.View
import github.mik0war.entity.UIEntity

interface TransferDataGetter<S: UIEntity<S>, R> {
    fun getTransferData(uiModel: S, view: View): R
}
