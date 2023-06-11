package github.mik0war.deliveryapp.feature.internetData.category.presentation

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.UIEntity
import github.mik0war.deliveryapp.feature.internetData.core.presentation.CustomTextView

sealed class CategoryUIModel : UIEntity<CategoryUIModel> {
    override fun equalsId(other: CategoryUIModel) = false

    override fun getImageUrl(): String = throw IllegalStateException()

    data class Success(
        private val id: Int,
        private val name: String,
        private val imageUrl: String
    ) : CategoryUIModel(){

        override fun equalsId(other: CategoryUIModel)
            = other is Success && other.id == this.id

        override fun getImageUrl() = imageUrl
        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }

        override fun <R, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(id, name, imageUrl)
    }


    class Error(
        private val failureMessage: String
    ): CategoryUIModel() {
        override fun show(nameView: CustomTextView) {
            nameView.set(failureMessage)
        }

        override fun <R, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(0, failureMessage, "")
    }
}