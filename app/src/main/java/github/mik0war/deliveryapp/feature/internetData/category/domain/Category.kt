package github.mik0war.deliveryapp.feature.internetData.category.domain

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity

sealed class Category(
    protected val name: String
) : Entity {
    override fun <R, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(0, name, "")
    class Success(
        private val id: Int,
        name: String,
        private val imageUrl: String
    ) : Category(name){
        override fun <R, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(id, name, imageUrl)
    }

    class Error(message: String): Category(message)
}
