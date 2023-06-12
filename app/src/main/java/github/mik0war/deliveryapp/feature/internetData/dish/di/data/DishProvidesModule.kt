package github.mik0war.deliveryapp.feature.internetData.dish.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishServerModel
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishService
import retrofit2.Retrofit

@Module
class DishProvidesModule {
    
    @Provides
    fun provideDishService(retrofit: Retrofit): DishService =
        retrofit.create(DishService::class.java)

    @Provides
    fun provideDataMapper(mapper: DishMapper<DishDataModel>) =
        object : DataMapper<DishServerModel, DishDataModel> {
            override fun map(dataObject: DishServerModel): DishDataModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToDishDataModel() =
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
    fun provideDishDataMapper(
        mapper: DishMapper<Dish>
    ) = object : DataMapper<DishDataModel, Dish> {
        override fun map(dataObject: DishDataModel): Dish = dataObject.map(mapper)
    }

    @Provides
    fun provideMapperToUI(mapper: DishMapper<DishUIModel>) =
        object : DataMapper<Dish, DishUIModel> {
            override fun map(dataObject: Dish): DishUIModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToUIModel() =
        object : DishMapper<DishUIModel> {

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

    @Provides
    fun provideMapperToDish() = object : DishMapper<Dish> {

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