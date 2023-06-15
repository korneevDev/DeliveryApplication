package github.mik0war.deliveryapp.feature.getListData.di

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.getListData.data.DishService
import retrofit2.Retrofit

@Module
class DishProvidesModule {
    
    @Provides
    fun provideDishService(retrofit: Retrofit): DishService =
        retrofit.create(DishService::class.java)

}