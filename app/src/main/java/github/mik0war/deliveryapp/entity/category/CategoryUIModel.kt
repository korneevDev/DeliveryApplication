package github.mik0war.deliveryapp.entity.category

import github.mik0war.deliveryapp.entity.UIEntity
import github.mik0war.deliveryapp.entity.CustomTextView

sealed class CategoryUIModel(
    id: Int = 0,
    name: String,
    imageUrl: String = ""
) : CategoryEntity(id, name, imageUrl), UIEntity<CategoryUIModel> {
    override fun equalsId(other: CategoryUIModel) = false

    override fun show(nameView: CustomTextView) {
        nameView.set(name)
    }
    override fun getUrl() = imageUrl
    class Success(
        id: Int,
        name: String,
        imageUrl: String
    ) : CategoryUIModel(id, name, imageUrl){

        override fun equalsId(other: CategoryUIModel)
            = other is Success && other.id == this.id

    }


    class Error(
        failureMessage: String
    ): CategoryUIModel(name = failureMessage) {
        override fun getUrl(): String = throw IllegalStateException()
    }
}