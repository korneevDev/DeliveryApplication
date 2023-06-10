package github.mik0war.deliveryapp.feature.internetData.category.di.data

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.MapperToCategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.data.cloud.CategoryServerModel
import github.mik0war.deliveryapp.feature.internetData.core.core.InternetDataMapper

@Module
class DataProviderModule {

    @Provides
    fun provideDataMapper(mapper: MapperToCategoryDataModel) =
        object : InternetDataMapper<CategoryServerModel, CategoryDataModel>{
            override fun map(dataObject: CategoryServerModel) =
                dataObject.map(mapper)
        }
}