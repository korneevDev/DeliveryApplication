package github.mik0war.deliveryapp.feature.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.core.StringResourceProvider
import github.mik0war.deliveryapp.feature.category.data.CategoryRepositoryImpl
import github.mik0war.deliveryapp.feature.category.domain.Category
import github.mik0war.deliveryapp.feature.category.domain.CategoryInteractor
import github.mik0war.deliveryapp.feature.category.domain.CategoryRepository
import github.mik0war.deliveryapp.feature.category.domain.ExceptionHandler
import github.mik0war.deliveryapp.feature.category.domain.MapperToCategory

@Module
abstract class DomainBaseModule {
    @Binds
    abstract fun bindRepository(repository: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindInteractor(interactor: CategoryInteractor.Base): CategoryInteractor

    @Binds
    abstract fun bindExceptionHandler(exception: ExceptionHandler.Base): ExceptionHandler

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider

    @Binds
    abstract fun bindMapper(mapper: MapperToCategory): CategoryMapper<Category>
}