package github.mik0war.deliveryapp.feature.internetData.category.di.presentation

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category
import github.mik0war.deliveryapp.feature.internetData.category.presentation.CategoryUIModel
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

@Module
class CategoryPresentationProviderModule {

    @Provides
    fun provideMapperToUI(mapper: CategoryMapper<CategoryUIModel>) =
        object : InternetDataMapper<Category, CategoryUIModel> {
            override fun map(dataObject: Category): CategoryUIModel =
                dataObject.map(mapper)
        }

    @Provides
    fun provideMapperToUIModel() =
        object : CategoryMapper<CategoryUIModel> {
            override fun map(id: Int, name: String, imageUrl: String) =
                if (id == 0 && imageUrl.isEmpty())
                    CategoryUIModel.Error(name)
                else
                    CategoryUIModel.Success(id, name, imageUrl)
        }

}