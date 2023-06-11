package github.mik0war.deliveryapp.entity.mapper


interface CategoryMapper<T> : Mapper<T> {
    fun map(id: Int, name: String, imageUrl: String): T
}