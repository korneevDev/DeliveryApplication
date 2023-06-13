package github.mik0war.deliveryapp.entity.dishCounted

import github.mik0war.deliveryapp.entity.CustomTextView
import github.mik0war.deliveryapp.entity.UIEntity

sealed class DishCountedUIModel(
    id: Int = 0,
    name: String,
    price: Int = 0,
    weight: Int = 0,
    description: String = "",
    image_url: String = "",
    tags: List<String> = emptyList(),
    count: Int = 0
) : DishCountedEntity(id, name, price, weight, description, image_url, tags, count),
    UIEntity<DishCountedUIModel> {
    override fun equalsId(other: DishCountedUIModel) = false

    fun getTotalPrice() = price * count

    override fun getUrl() = image_url

    override fun show(nameView: CustomTextView) {
        nameView.set(name)
    }

    open fun show(nameView: CustomTextView,
                  priceView: CustomTextView,
                  weightView: CustomTextView,
                  countView: CustomTextView,
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
        tags: List<String>,
        count: Int
    ) : DishCountedUIModel(id, name, price, weight, description, image_url, tags, count){

        override fun equalsId(other: DishCountedUIModel)
                = other is Success && other.id == this.id

        override fun show(
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
    }

    class Error(
        failureMessage: String
    ): DishCountedUIModel(name=failureMessage) {
        override fun getUrl(): String = throw IllegalStateException()
    }
}