package github.mik0war.deliveryapp.feature.internetData.category.di.domain

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.entity.mapper.CategoryMapper
import github.mik0war.deliveryapp.entity.InternetDataMapper

@Module
class CategoryDomainProviderModule {

    @Provides
    fun provideCategoryDataMapper(
        mapper: CategoryMapper<Category>
    ) = object : InternetDataMapper<CategoryDataModel, Category> {
        override fun map(dataObject: CategoryDataModel): Category = dataObject.map(mapper)
    }

    @Provides
    fun provideMapperToCategory() = object : CategoryMapper<Category> {
        override fun map(id: Int, name: String, imageUrl: String) =
            if (id == 0 && imageUrl.isEmpty())
                Category.Error(name)
            else
                Category.Success(id, name, imageUrl)
    }
}
