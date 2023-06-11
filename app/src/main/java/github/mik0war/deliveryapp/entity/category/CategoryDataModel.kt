package github.mik0war.deliveryapp.entity.category

import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.mapper.CategoryMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper

data class CategoryDataModel(
    private val id: Int,
    private val name: String,
    private val imageUrl: String
) : Entity {
    override fun <R: Mapper<T>, T> map(mapper: R): T =
        (mapper as CategoryMapper<T>).map(id, name, imageUrl)
}
