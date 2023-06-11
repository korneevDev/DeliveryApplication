package github.mik0war.deliveryapp.feature.internetData.dish.core

interface DishMapper<T> {
    fun map(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>
    ): T
}