package github.mik0war.deliveryapp.feature.category.presentation

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper

sealed class CategoryUIModel {
    open fun equalsId(other: CategoryUIModel) = false

    abstract fun map(mapper: CategoryMapper<Unit>)

    data class Success(
        private val id: Int,
        private val name: String,
        private val imageUrl: String
    ) : CategoryUIModel(){

        override fun equalsId(other: CategoryUIModel)
            = other is Success && other.id == this.id

        override fun map(mapper: CategoryMapper<Unit>) = mapper.map(id, name, imageUrl)

    }


    class Error(
        private val failureMessage: String
    ): CategoryUIModel() {
        override fun map(mapper: CategoryMapper<Unit>) = mapper.map(0, failureMessage, "")
    }
}