package github.mik0war.deliveryapp.feature.category.core

interface CategoryMapper<T> {
    fun map(id: Int, name: String, imageIrl: String): T
}