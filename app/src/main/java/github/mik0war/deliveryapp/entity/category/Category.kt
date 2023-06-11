package github.mik0war.deliveryapp.entity.category

import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.CategoryMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper

sealed class Category(
    protected val name: String
) : Entity {
    override fun <R: Mapper<T>, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(0, name, "")
    class Success(
        private val id: Int,
        name: String,
        private val imageUrl: String
    ) : Category(name){
        override fun <R: Mapper<T>, T> map(mapper: R): T = (mapper as CategoryMapper<T>).map(id, name, imageUrl)
    }

    class Error(message: String): Category(message)
}
