package github.mik0war.category.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.category.data.CategoryService
import retrofit2.Retrofit

@Module
class CategoryDataProviderModule {
    @Provides
    fun provideCategoryService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)
}