package github.mik0war.deliveryapp.entity.category

import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.entity.mapper.CategoryMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper
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

        override fun <R: Mapper<T>, T> map(mapper: R): T =
            (mapper as CategoryMapper<T>).map(id, name, imageUrl)
    }


    class Error(
        private val failureMessage: String
    ): CategoryUIModel() {
        override fun show(nameView: CustomTextView) {
            nameView.set(failureMessage)
        }

        override fun <R: Mapper<T>, T> map(mapper: R): T =
            (mapper as CategoryMapper<T>).map(0, failureMessage, "")
    }
}