package github.mik0war.deliveryapp.feature.shoppingCart.show.di

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedDataModel
import github.mik0war.deliveryapp.entity.mapper.DishCountedMapperTo
import github.mik0war.deliveryapp.entity.mapper.DishMapperTo
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDataBase
import github.mik0war.deliveryapp.feature.shoppingCart.core.GetDishDAO

@Module
class ShowCartProvidesModule {

    @Provides
    fun provideDAO(db: DishDataBase): GetDishDAO = db.getDishListDAO()


    @Provides
    fun provideMapperToDishCountedDataModel() =
        object : DishCountedMapperTo<DishCountedDataModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) = DishCountedDataModel(id, name, price, weight, description, image_url, tags, count)
        }

    @Provides
    fun provideMapperToDish() = object : DishMapperTo<Dish> {

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

    @Provides
    fun provideDishDataMapper(
        mapper: DishMapperTo<Dish>
    ) = object : DataMapper<DishDataModel, Dish> {
        override fun map(dataObject: DishDataModel): Dish = dataObject.map(mapper)
    }

    @Provides
    fun provideMapperToUI(mapper: DishMapperTo<DishUIModel>) =
        object : DataMapper<Dish, DishUIModel> {
            override fun map(dataObject: Dish): DishUIModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToUIModel() =
        object : DishMapperTo<DishUIModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ): DishUIModel =
                if (id == 0 && price == 0 && weight == 0 && description.isEmpty() &&
                    image_url.isEmpty() && tags.isEmpty())
                    DishUIModel.Error(name)
                else
                    DishUIModel.Success(id, name, price, weight, description, image_url, tags)
        }


}