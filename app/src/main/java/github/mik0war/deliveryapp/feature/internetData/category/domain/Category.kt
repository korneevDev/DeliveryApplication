package github.mik0war.deliveryapp.feature.internetData.category.domain

import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.Entity
import javax.inject.Inject

sealed class Category(
    protected val name: String
) : Entity {
    override fun <T> map(mapper: CategoryMapper<T>) = mapper.map(0, name, "")
    class Success(
        private val id: Int,
        name: String,
        private val imageUrl: String
    ) : Category(name){
        override fun <T> map(mapper: CategoryMapper<T>): T = mapper.map(id, name, imageUrl)
    }

    class Error(message: String): Category(message)
}

class MapperToCategory @Inject constructor() : CategoryMapper<Category> {
    override fun map(id: Int, name: String, imageUrl: String) =
        Category.Success(id, name, imageUrl)
}
