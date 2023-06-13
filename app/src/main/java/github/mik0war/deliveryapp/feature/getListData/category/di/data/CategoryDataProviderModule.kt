package github.mik0war.deliveryapp.feature.getListData.category.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.mapper.CategoryMapperTo
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.feature.getListData.category.data.CategoryServerModel
import github.mik0war.deliveryapp.feature.getListData.category.data.CategoryService
import github.mik0war.deliveryapp.entity.DataMapper
import retrofit2.Retrofit

@Module
class CategoryDataProviderModule {
    @Provides
    fun provideCategoryService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)

    @Provides
    fun provideDataMapper(mapper: CategoryMapperTo<CategoryDataModel>) =
        object : DataMapper<CategoryServerModel, CategoryDataModel> {
            override fun map(dataObject: CategoryServerModel): CategoryDataModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToCategory() =
        object : CategoryMapperTo<CategoryDataModel> {
            override fun map(id: Int, name: String, imageUrl: String) =
                CategoryDataModel(id, name, imageUrl)
        }
}