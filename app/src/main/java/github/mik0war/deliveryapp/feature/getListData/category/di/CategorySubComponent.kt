package github.mik0war.deliveryapp.feature.getListData.category.di

import dagger.Subcomponent
import github.mik0war.deliveryapp.feature.getListData.category.di.data.CategoryDataBindsModule
import github.mik0war.deliveryapp.feature.getListData.category.di.data.CategoryDataProviderModule
import github.mik0war.deliveryapp.feature.getListData.category.di.domain.CategoryDomainBindsModule
import github.mik0war.deliveryapp.feature.getListData.category.di.domain.CategoryDomainProviderModule
import github.mik0war.deliveryapp.feature.getListData.category.di.presentation.CategoryPresentationBaseModule
import github.mik0war.deliveryapp.feature.getListData.category.di.presentation.CategoryPresentationProviderModule
import github.mik0war.deliveryapp.feature.getListData.category.presentation.CategoryListFragment

@Subcomponent(modules = [
    CategoryDataBindsModule::class,
    CategoryDataProviderModule::class,
    CategoryDomainBindsModule::class,
    CategoryDomainProviderModule::class,
    CategoryPresentationBaseModule::class,
    CategoryPresentationProviderModule::class
])
interface CategorySubComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): CategorySubComponent
    }

    fun inject(fragment: CategoryListFragment)
}