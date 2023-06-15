package github.mik0war.deliveryapp.feature.shoppingCart.fill.di

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDAO
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDataBase
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel
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
}