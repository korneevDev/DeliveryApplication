package github.mik0war.deliveryapp.feature.category.domain

sealed class Category(
    private val name: String
) {
    class Success(
        private val id: Int,
        name: String,
        private val imageUrl: String
    ) : Category(name)

    class Error(
        message: String
    ) : Category(message)
}
