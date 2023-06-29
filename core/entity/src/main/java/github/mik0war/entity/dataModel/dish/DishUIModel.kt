package github.mik0war.entity.dataModel.dish

import github.mik0war.entity.CustomTextView
import github.mik0war.entity.UIEntity

sealed interface DishUIModel : DishEntity, UIEntity<DishUIModel> {

    fun show(nameView: CustomTextView,
             priceView: CustomTextView,
             weightView: CustomTextView,
             descriptionView: CustomTextView,
             priceAddition: String,
             weightPrefix: String,
             weightMeasure: String,
    )
    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>
    ) : DishUIModel, DishEntity.Success(id, name, price, weight, description, image_url, tags){

        override fun equalsId(other: DishUIModel)
                = other is Success && other.id == this.id

        override fun getUrl(): String = image_url

        override fun getCurrentName(): String = name

        override fun getTagsList(): List<String> = tags

        override fun show(
            nameView: CustomTextView,
            priceView: CustomTextView,
            weightView: CustomTextView,
            descriptionView: CustomTextView,
            priceAddition: String,
            weightPrefix: String,
            weightMeasure: String,
        ) {
            nameView.set(name)
            priceView.set("$price $priceAddition")
            weightView.set(" $weightPrefix $weight $weightMeasure")
            descriptionView.set(description)
        }

        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }
    }


    class Error(
        failureMessage: String
    ): DishUIModel, DishEntity.Error(failureMessage) {
        override fun getUrl(): String = throw IllegalStateException()

        override fun equalsId(other: DishUIModel) = false

        override fun getTagsList(): List<String> = emptyList()

        override fun show(nameView: CustomTextView) {
            nameView.set(errorMessage)
        }

        override fun show(nameView: CustomTextView,
                      priceView: CustomTextView,
                      weightView: CustomTextView,
                      descriptionView: CustomTextView,
                      priceAddition: String,
                      weightPrefix: String,
                      weightMeasure: String,
        ): Unit = throw IllegalStateException()

        override fun getCurrentName(): String = errorMessage
    }
}