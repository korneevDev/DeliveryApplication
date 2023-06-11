package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import github.mik0war.deliveryapp.feature.internetData.core.core.UIEntity
import github.mik0war.deliveryapp.feature.internetData.core.presentation.CustomTextView
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper

sealed class DishUIModel : UIEntity<DishUIModel> {
    override fun equalsId(other: DishUIModel) = false

    override fun getImageUrl(): String = throw IllegalStateException()


    data class Success(
        private val id: Int,
        private val name: String,
        private val price: Int,
        private val weight: Int,
        private val description: String,
        private val imageUrl: String,
        private val tags: List<String>,
    ) : DishUIModel(){

        override fun equalsId(other:DishUIModel)
                = other is Success && other.id == this.id

        override fun getImageUrl() = imageUrl

        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }

        override fun <S, R> map(mapper: S) =
            (mapper as DishMapper<R>).map(id, name, price, weight, description, imageUrl, tags)
    }


    class Error(
        private val failureMessage: String
    ): DishUIModel() {
        override fun show(nameView: CustomTextView) {
            nameView.set(failureMessage)
        }

        override fun <S, R> map(mapper: S) =
            (mapper as DishMapper<R>)
                .map(0, failureMessage, 0, 0, "", "", emptyList())
    }
}