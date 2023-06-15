package github.mik0war.entity.dataModel.dish

import github.mik0war.entity.CustomTextView
import github.mik0war.entity.UIEntity

sealed class DishUIModel(
    id: Int = 0,
    name: String,
    price: Int = 0,
    weight: Int = 0,
    description: String = "",
    image_url: String = "",
    tags: List<String> = emptyList()
) : DishEntity(id, name, price, weight, description, image_url, tags),
    UIEntity<DishUIModel> {
    override fun equalsId(other: DishUIModel) = false

    override fun getUrl() = image_url
    override fun getTagsList(): List<String> = tags

    override fun show(nameView: CustomTextView) {
        nameView.set(name)
    }

    open fun show(nameView: CustomTextView,
                  priceView: CustomTextView,
                  weightView: CustomTextView,
                  descriptionView: CustomTextView,
                  priceAddition: String,
                  weightPrefix: String,
                  weightMeasure: String,
    ): Unit = throw IllegalStateException()

    override fun getCurrentName(): String = name

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>
    ) : DishUIModel(id, name, price, weight, description, image_url, tags){

        override fun equalsId(other: DishUIModel)
                = other is Success && other.id == this.id

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
    }


    class Error(
        failureMessage: String
    ): DishUIModel(name=failureMessage) {
        override fun getUrl(): String = throw IllegalStateException()
    }
}