package github.mik0war.deliveryapp.feature.internetData.dish.di.presentation

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper
import github.mik0war.deliveryapp.feature.internetData.dish.domain.Dish
import github.mik0war.deliveryapp.feature.internetData.dish.presentation.DishUIModel

@Module
class DishPresentationProviderModule {

    @Provides
    fun provideMapperToUI(mapper: DishMapper<DishUIModel>) =
        object : InternetDataMapper<Dish, DishUIModel> {
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

}