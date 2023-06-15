package github.mik0war.entity.dataModel.dishCounted

class DishCountedDataModel(
    id: Int,
    name: String,
    price: Int,
    weight: Int,
    description: String,
    image_url: String,
    tags: List<String>,
    count: Int
) : DishCountedEntity(id, name, price, weight, description, image_url, tags, count)