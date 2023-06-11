package github.mik0war.deliveryapp.entity.category

sealed class Category(
    id: Int = 0,
    name: String,
    imageUrl: String = ""
) : CategoryEntity(id, name, imageUrl) {
    class Success(
        id: Int,
        name: String,
        imageUrl: String
    ) : Category(id, name, imageUrl){
    }

    class Error(message: String): Category(name=message)
}
