package github.mik0war.entity.dataModel.dishCounted

import github.mik0war.entity.CustomTextView
import github.mik0war.entity.UIEntity

sealed interface DishCountedUIModel : DishCountedEntity,
    UIEntity<DishCountedUIModel> {

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>,
        count: Int
    ) : DishCountedUIModel,
        DishCountedEntity.Success(id, name, price, weight, description, image_url, tags, count){

        override fun equalsId(other: DishCountedUIModel)
                = other is Success && other.id == this.id

        fun show(
            nameView: CustomTextView,
            priceView: CustomTextView,
            weightView: CustomTextView,
            countView: CustomTextView,
            priceAddition: String,
            weightPrefix: String,
            weightMeasure: String,
        ) {
            nameView.set(name)
            priceView.set("$price $priceAddition")
            weightView.set(" $weightPrefix $weight $weightMeasure")
            countView.set(count.toString())
        }

        fun showCount(countView: CustomTextView){
            countView.set(count.toString())
        }

        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }

        override fun getCurrentName(): String = name

        fun getTotalPrice() = price * count
        override fun getTagsList(): List<String> = tags

        override fun getUrl() = image_url

    }

    class Error(
        failureMessage: String
    ): DishCountedUIModel, DishCountedEntity.Error(failureMessage) {
        override fun getUrl(): String = throw IllegalStateException()
        override fun equalsId(other: DishCountedUIModel) = false

        override fun getCurrentName(): String = errorMessage
        override fun getTagsList(): List<String> = emptyList()

        override fun show(nameView: CustomTextView) {
            nameView.set(errorMessage)
        }
    }
}