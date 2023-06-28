package github.mik0war.entity.dataModel.mapper

sealed interface MapperTo<T>{
    fun mapError(name: String): T
}
