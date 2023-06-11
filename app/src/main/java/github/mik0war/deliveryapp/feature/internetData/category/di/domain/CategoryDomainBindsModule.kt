package github.mik0war.deliveryapp.feature.internetData.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.feature.internetData.category.domain.CategoryExceptionHandler
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.feature.internetData.core.data.InternetDataRepositoryImpl
import github.mik0war.deliveryapp.feature.internetData.core.domain.ExceptionHandler
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataInteractor
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataRepository

@Module
abstract class CategoryDomainBindsModule {
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
}