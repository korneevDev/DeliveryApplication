package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import android.app.Dialog
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import github.mik0war.deliveryapp.R
import github.mik0war.entity.CustomTextView
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.recycler_list.core.presentation.ImageLoader

interface DishDialogConfigurator {
    fun configureDialog(
        dialog: Dialog,
        dishUIModel: DishUIModel,
        onClickListener: (uiModel: DishUIModel) -> Unit
    ): Dialog

    class Base(
        private val imageLoader: ImageLoader,
        private val stringResourceProvider: StringResourceProvider
    ) : DishDialogConfigurator {
        override fun configureDialog(
            dialog: Dialog,
            dishUIModel: DishUIModel,
            onClickListener: (uiModel: DishUIModel) -> Unit
        ): Dialog {
            dialog.setContentView(R.layout.dialog_layout)
            dialog.setCancelable(false)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            val cancelButton = dialog.findViewById<ImageButton>(R.id.cancelButton)
            cancelButton.setOnClickListener {
                dialog.dismiss()
            }

            val applyButton = dialog.findViewById<Button>(R.id.applyButton)
            applyButton.setOnClickListener{
                onClickListener.invoke(dishUIModel)
                dialog.dismiss()
            }

            val nameView = dialog.findViewById<CustomTextView>(R.id.objectName)
            val priceView = dialog.findViewById<CustomTextView>(R.id.priceView)
            val weightView = dialog.findViewById<CustomTextView>(R.id.weightView)
            val descriptionView = dialog.findViewById<CustomTextView>(R.id.descriptionView)

            dishUIModel.show(
                nameView, priceView, weightView, descriptionView,
                weightMeasure = stringResourceProvider.getString(R.string.weight_measure),
                priceAddition = stringResourceProvider.getString(R.string.price_addition),
                weightPrefix = stringResourceProvider.getString(R.string.weight_prefix)
            )

            val imageHolder = dialog.findViewById<ImageView>(R.id.imageHolder)

            imageLoader.loadImage(dishUIModel.getUrl(), imageHolder)

            return dialog
        }
    }
}