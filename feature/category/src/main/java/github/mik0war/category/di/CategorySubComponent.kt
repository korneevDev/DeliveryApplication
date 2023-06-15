package github.mik0war.category.di

import dagger.Subcomponent
import github.mik0war.category.di.data.CategoryDataBindsModule
import github.mik0war.category.di.data.CategoryDataProviderModule
import github.mik0war.category.di.domain.CategoryDomainBindsModule
import github.mik0war.category.di.presentation.CategoryPresentationBaseModule
import github.mik0war.category.presentation.CategoryListFragment

@Subcomponent(modules = [
    CategoryDataBindsModule::class,
    CategoryDataProviderModule::class,
    CategoryDomainBindsModule::class,
    CategoryPresentationBaseModule::class
])
interface CategorySubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): CategorySubComponent
    }

    fun inject(fragment: CategoryListFragment)
}

interface CategorySubComponentProvider {
    fun provideCategorySubComponent(): CategorySubComponent
}