package github.mik0war.deliveryapp.feature.internetData.category.core

interface CategoryMapper<T> {
    fun map(id: Int, name: String, imageUrl: String): T
}