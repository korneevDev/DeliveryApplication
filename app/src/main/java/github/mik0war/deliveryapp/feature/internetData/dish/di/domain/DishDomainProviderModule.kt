package github.mik0war.deliveryapp.feature.internetData.dish.di.domain

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.mapper.DishMapper
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.Dish

@Module
class DishDomainProviderModule {

    @Provides
    fun provideDishDataMapper(
        mapper: DishMapper<Dish>
    ) = object : DataMapper<DishDataModel, Dish> {
        override fun map(dataObject: DishDataModel): Dish = dataObject.map(mapper)
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
