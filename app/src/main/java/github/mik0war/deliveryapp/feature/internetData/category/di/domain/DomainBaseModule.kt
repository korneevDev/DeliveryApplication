package github.mik0war.deliveryapp.feature.internetData.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.internetData.category.domain.Category
import github.mik0war.deliveryapp.feature.internetData.category.domain.CategoryExceptionHandler
import github.mik0war.deliveryapp.feature.internetData.category.domain.MapperToCategory
import github.mik0war.deliveryapp.feature.internetData.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.internetData.core.core.StringResourceProvider
import github.mik0war.deliveryapp.feature.internetData.core.data.InternetDataRepositoryImpl
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataInteractor
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataRepository
import github.mik0war.deliveryapp.feature.internetData.core.domain.ExceptionHandler

@Module
abstract class DomainBaseModule {
    @Binds
    abstract fun bindRepository(
        repository: InternetDataRepositoryImpl<CategoryDataModel>
    ): InternetDataRepository<CategoryDataModel>

    @Binds
    abstract fun bindInteractor(
        interactor: InternetDataInteractor.Base<CategoryDataModel, Category>
    ): InternetDataInteractor<Category>

    @Binds
    abstract fun bindExceptionHandler(
        exception: CategoryExceptionHandler
    ): ExceptionHandler<Category>

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider

    @Binds
    abstract fun bindMapper(mapper: MapperToCategory): CategoryMapper<Category>
}