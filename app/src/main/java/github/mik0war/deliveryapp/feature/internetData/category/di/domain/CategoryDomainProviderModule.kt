package github.mik0war.deliveryapp.feature.internetData.category.di.domain

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

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
