package github.mik0war.deliveryapp.entity.dish

sealed class Dish(
    id: Int = 0,
    name: String,
    price: Int = 0,
    weight: Int = 0,
    description: String = "",
    image_url: String = "",
    tags: List<String> = emptyList()
) : DishEntity(id, name, price, weight, description, image_url, tags) {

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>
    ) : Dish(id, name, price, weight, description, image_url, tags)

    class Error(message: String): Dish(name=message)
}