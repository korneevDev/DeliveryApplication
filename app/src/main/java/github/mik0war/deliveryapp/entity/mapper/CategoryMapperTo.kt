package github.mik0war.deliveryapp.entity.mapper


interface CategoryMapperTo<T> : MapperTo<T> {
    fun map(id: Int, name: String, imageUrl: String): T
}