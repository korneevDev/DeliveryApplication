package github.mik0war.entity.dataModel.mapper


interface CategoryMapperTo<T> : MapperTo<T> {
    fun map(id: Int, name: String, imageUrl: String): T
}