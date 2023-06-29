package github.mik0war.database_communication.di

import dagger.Module
import dagger.Provides
import github.mik0war.database.DishCacheModel
import github.mik0war.database.DishDAO
import github.mik0war.database.DishDataBase
import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.entity.dataModel.dishCounted.DishCountedDataModel
import github.mik0war.entity.dataModel.mapper.DishCountedMapperTo
import github.mik0war.entity.dataModel.mapper.DishMapperTo

@Module
class FillCartProvidesModule {
    @Provides
    fun provideDAO(db: DishDataBase): DishDAO = db.fillShoppingCartDAO()

    @Provides
    fun provideMapperDataModelToCacheModel(
        mapperTo: DishMapperTo<DishCacheModel>
    ): DataMapper<DishDataModel, DishCacheModel> =
        object : DataMapper<DishDataModel, DishCacheModel>{
            override fun map(dataObject: DishDataModel): DishCacheModel =
                dataObject.map(mapperTo)
        }

    @Provides
    fun provideMapperDataCountedModelToCacheModel(
        mapperTo: DishCountedMapperTo<DishCacheModel>
    ): DataMapper<DishCountedDataModel, DishCacheModel> =
        object : DataMapper<DishCountedDataModel, DishCacheModel>{
            override fun map(dataObject: DishCountedDataModel): DishCacheModel =
                dataObject.map(mapperTo)
        }

    @Provides
    fun provideMapperToCacheDataModel(): DishMapperTo<DishCacheModel> =
        object : DishMapperTo<DishCacheModel> {
            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ) = DishCacheModel(
                id,
                name,
                price,
                weight,
                description,
                image_url,
                tags
            )

            override fun mapError(name: String): DishCacheModel = throw IllegalStateException()
        }

    @Provides
    fun provideCountedMapperToCacheDataModel(): DishCountedMapperTo<DishCacheModel> =
        object : DishCountedMapperTo<DishCacheModel> {
            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) = DishCacheModel(
                id,
                name,
                price,
                weight,
                description,
                image_url,
                tags
            )
                .also { it.count = count }

            override fun mapError(name: String): DishCacheModel = throw IllegalStateException()
        }
}