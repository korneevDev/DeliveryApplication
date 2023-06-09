package github.mik0war.deliveryapp.feature.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.category.data.CategoryRepositoryImpl
import github.mik0war.deliveryapp.feature.category.domain.CategoryRepository

@Module
abstract class DomainBaseModule {
    @Binds
    abstract fun bindRepository(repository: CategoryRepositoryImpl): CategoryRepository
}