package github.mik0war.deliveryapp.feature.category.domain

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper

sealed class Category(
    protected val name: String
) {
    open fun <T> map(mapper: CategoryMapper<T>) = mapper.map(0, name, "")
    class Success(
        private val id: Int,
        name: String,
        private val imageUrl: String
    ) : Category(name){
        override fun <T> map(mapper: CategoryMapper<T>): T = mapper.map(id, name, imageUrl)
    }

    class Error(message: String): Category(message)
}
