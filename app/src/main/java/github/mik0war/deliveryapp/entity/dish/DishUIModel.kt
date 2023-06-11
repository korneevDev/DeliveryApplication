package github.mik0war.deliveryapp.entity.dish

import github.mik0war.deliveryapp.entity.CustomTextView
import github.mik0war.deliveryapp.entity.UIEntity

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

    override fun getImageUrl() = image_url

    override fun show(nameView: CustomTextView) {
        nameView.set(name)
    }
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
    }


    class Error(
        failureMessage: String
    ): DishUIModel(name=failureMessage) {
        override fun getImageUrl(): String = throw IllegalStateException()
    }
}