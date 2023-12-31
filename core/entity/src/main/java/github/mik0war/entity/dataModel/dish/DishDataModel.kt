package github.mik0war.entity.dataModel.dish

class DishDataModel(
    id: Int,
    name: String,
    price: Int,
    weight: Int,
    description: String,
    image_url: String,
    tags: List<String>
) : DishEntity.Success(id, name, price, weight, description, image_url, tags)