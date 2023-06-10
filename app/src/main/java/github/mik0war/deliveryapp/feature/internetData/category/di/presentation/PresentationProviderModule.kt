package github.mik0war.deliveryapp.feature.internetData.category.di.presentation

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category
import github.mik0war.deliveryapp.feature.internetData.category.presentation.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

@Module
class PresentationProviderModule {

    @Provides
    fun provideMapperToUI(mapper: CategoryMapper<CategoryUIModel>) =
        object: InternetDataMapper<Category, CategoryUIModel>{
            override fun map(dataObject: Category) =
                dataObject.map(mapper)
        }
}