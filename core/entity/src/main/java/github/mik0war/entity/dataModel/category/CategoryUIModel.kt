package github.mik0war.entity.dataModel.category

import github.mik0war.entity.CustomTextView
import github.mik0war.entity.UIEntity

sealed interface CategoryUIModel : UIEntity<CategoryUIModel> {
    class Success(
        id: Int,
        name: String,
        imageUrl: String
    ) : CategoryUIModel, CategoryEntity.Success(id, name, imageUrl){

        override fun equalsId(other: CategoryUIModel): Boolean =
            if (other is Success) super.equalsId(other) else false

        override fun getUrl() = imageUrl
        override fun getCurrentName(): String = name

        override fun getTagsList(): List<String> = getTagsForFilter()

        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }
    }


    class Error(
        failureMessage: String
    ): CategoryUIModel, CategoryEntity.Error(failureMessage) {
        override fun equalsId(other: CategoryUIModel) = false

        override fun show(nameView: CustomTextView) {
            nameView.set(name)
        }

        override fun getUrl(): String = throw IllegalStateException()

        override fun getCurrentName() = name
        override fun getTagsList(): List<String> = emptyList()


    }
}