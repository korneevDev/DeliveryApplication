package github.mik0war.entity.dataModel.category

import github.mik0war.entity.CustomTextView
import github.mik0war.entity.UIEntity

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

    override fun getCurrentName() = name

    override fun getTagsList(): List<String> = emptyList()

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