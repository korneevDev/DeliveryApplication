package github.mik0war.deliveryapp.feature.internetData.category.presentation

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.UIEntity
import github.mik0war.deliveryapp.feature.internetData.core.presentation.CustomTextView
import javax.inject.Inject

sealed class CategoryUIModel : UIEntity<CategoryUIModel> {
    override fun equalsId(other: CategoryUIModel) = false

    open fun getURL(): String = throw IllegalStateException()

    data class Success(
        private val id: Int,
        private val name: String,
        private val imageUrl: String
    ) : CategoryUIModel(){

        override fun equalsId(other: CategoryUIModel)
            = other is Success && other.id == this.id

        override fun <T> map(mapper: CategoryMapper<T>) = mapper.map(id, name, imageUrl)

        override fun getURL() = imageUrl
    }


    class Error(
        private val failureMessage: String
    ): CategoryUIModel() {
        override fun <T> map(mapper: CategoryMapper<T>) = mapper.map(0, failureMessage, "")
    }
}

class MapperToUIModel @Inject constructor(): CategoryMapper<CategoryUIModel> {
    override fun map(id: Int, name: String, imageUrl: String) =
        CategoryUIModel.Success(id, name, imageUrl)
}

class MapperToUI(
    private val headerView: CustomTextView
) : CategoryMapper<Unit> {
    override fun map(id: Int, name: String, imageUrl: String) {
        headerView.set(name)
    }
}