package github.mik0war.entity.dataModel.mapper

interface DishMapperTo<T> : MapperTo<T> {
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