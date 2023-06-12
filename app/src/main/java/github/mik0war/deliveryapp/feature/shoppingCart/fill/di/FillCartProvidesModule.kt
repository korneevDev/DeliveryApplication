package github.mik0war.deliveryapp.feature.shoppingCart.fill.di

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.mapper.Mapper
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDAO
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDataBase
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel

@Module
class FillCartProvidesModule {

    @Provides
    fun provideDAO(db: DishDataBase): DishDAO = db.fillShoppingCartDAO()

    @Provides
    fun provideMapperToCacheDataModel(): Mapper<DishCacheModel> =
        object : DishMapper<DishCacheModel>{
            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ) = DishCacheModel(id, name, price, weight, description, image_url, tags)
        }

    @Provides
    fun provideMapperToDishDataModel(): Mapper<DishDataModel> =
        object : DishMapper<DishDataModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ) = DishDataModel(id, name, price, weight, description, image_url, tags)
        }

    @Provides
    fun provideMapperToDish(): Mapper<Dish> = object : DishMapper<Dish> {

        override fun map(
            id: Int,
            name: String,
            price: Int,
            weight: Int,
            description: String,
            image_url: String,
            tags: List<String>
        ): Dish =
            if (id == 0 && price == 0 && weight == 0 && description.isEmpty() &&
                image_url.isEmpty() && tags.isEmpty())
                Dish.Error(name)
            else
                Dish.Success(id, name, price, weight, description, image_url, tags)
    }
}