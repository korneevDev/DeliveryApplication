package github.mik0war.entity.dataModel.category

import github.mik0war.entity.Entity

sealed interface Category : Entity {
    class Success(
        id: Int,
        name: String,
        imageUrl: String
    ) : Category, CategoryEntity.Success(id, name, imageUrl)

    class Error(message: String): Category, CategoryEntity.Error(message)
}
