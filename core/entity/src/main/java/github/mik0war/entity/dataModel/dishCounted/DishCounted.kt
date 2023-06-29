package github.mik0war.entity.dataModel.dishCounted

sealed interface DishCounted : DishCountedEntity {

    class Success(
        id: Int,
        name: String,
        price: Int,
        weight: Int,
        description: String,
        image_url: String,
        tags: List<String>,
        count: Int
    ) : DishCounted, DishCountedEntity.Success(id, name, price, weight, description, image_url, tags, count)

    class Error(message: String): DishCounted, DishCountedEntity.Error(message)
}