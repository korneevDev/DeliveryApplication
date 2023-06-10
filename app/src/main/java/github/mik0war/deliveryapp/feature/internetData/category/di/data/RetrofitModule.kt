package github.mik0war.deliveryapp.feature.internetData.category.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.data.cloud.CategoryService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    // Main Service
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCategoryService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)


    /* Test offline service
    @Singleton
    @Provides
    fun provideCategoryService(): CategoryService =
        TestCategoryService()

    */
}