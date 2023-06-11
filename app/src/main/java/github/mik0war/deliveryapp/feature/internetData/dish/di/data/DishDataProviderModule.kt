package github.mik0war.deliveryapp.feature.internetData.dish.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper
import github.mik0war.deliveryapp.feature.internetData.dish.core.DishMapper
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishDataModel
import github.mik0war.deliveryapp.feature.internetData.dish.data.cloud.DishServerModel
import github.mik0war.deliveryapp.feature.internetData.dish.data.cloud.DishService
import retrofit2.Retrofit

@Module
class DishDataProviderModule {
    
    @Provides
    fun provideDishService(retrofit: Retrofit): DishService =
        retrofit.create(DishService::class.java)

    @Provides
    fun provideDataMapper(mapper: DishMapper<DishDataModel>) =
        object : InternetDataMapper<DishServerModel, DishDataModel>{
            override fun map(dataObject: DishServerModel): DishDataModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToDish() =
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
}