package github.mik0war.entity.dataModel.dishCounted

sealed class DishCounted(
    id: Int = 0,
    name: String,
    price: Int = 0,
    weight: Int = 0,
    description: String = "",
    image_url: String = "",
    tags: List<String> = emptyList(),
    count: Int = 0
) : DishCountedEntity(id, name, price, weight, description, image_url, tags, count) {

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>,
        count: Int
    ) : DishCounted(id, name, price, weight, description, image_url, tags, count)

    class Error(message: String): DishCounted(name=message)
}