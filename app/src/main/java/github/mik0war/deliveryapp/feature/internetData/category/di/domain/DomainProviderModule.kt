package github.mik0war.deliveryapp.feature.internetData.category.di.domain

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

@Module
class DomainProviderModule {

    @Provides
    fun provideCategoryDataMapper(
        mapper: CategoryMapper<Category>
    ) = object : InternetDataMapper<CategoryDataModel, Category> {
        override fun map(dataObject: CategoryDataModel) = dataObject.map(mapper)
    }
}
