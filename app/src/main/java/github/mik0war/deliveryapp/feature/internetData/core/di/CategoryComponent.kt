package github.mik0war.deliveryapp.feature.internetData.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.deliveryapp.feature.internetData.category.presentation.CategoryListFragment
import github.mik0war.deliveryapp.feature.internetData.category.di.core.DispatchersModule
import github.mik0war.deliveryapp.feature.internetData.category.di.data.DataBaseModule
import github.mik0war.deliveryapp.feature.internetData.category.di.data.DataProviderModule
import github.mik0war.deliveryapp.feature.internetData.category.di.data.RetrofitModule
import github.mik0war.deliveryapp.feature.internetData.category.di.domain.DomainBaseModule
import github.mik0war.deliveryapp.feature.internetData.category.di.domain.DomainProviderModule
import github.mik0war.deliveryapp.feature.internetData.category.di.presentation.PresentationBaseModule
import github.mik0war.deliveryapp.feature.internetData.category.di.presentation.PresentationProviderModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataBaseModule::class,
    DataProviderModule::class,
    RetrofitModule::class,
    DomainBaseModule::class,
    PresentationBaseModule::class,
    DispatchersModule::class,
    DomainProviderModule::class,
    PresentationProviderModule::class
])
interface CategoryComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): CategoryComponent
    }

    fun inject(fragment: CategoryListFragment)
}