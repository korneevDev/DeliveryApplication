package github.mik0war.entity.dataModel.dish

sealed interface Dish : DishEntity{

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>
    ) : Dish, DishEntity.Success(id, name, price, weight, description, image_url, tags)

    class Error(message: String): Dish, DishEntity.Error(message)
}