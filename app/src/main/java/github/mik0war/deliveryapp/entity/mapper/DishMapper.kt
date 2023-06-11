package github.mik0war.deliveryapp.entity.mapper

interface DishMapper<T> : Mapper<T> {
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