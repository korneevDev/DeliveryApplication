package github.mik0war.deliveryapp.feature.category.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.deliveryapp.feature.category.di.core.DispatchersModule
import github.mik0war.deliveryapp.feature.category.di.data.DataBaseModule
import github.mik0war.deliveryapp.feature.category.di.data.RetrofitModule
import github.mik0war.deliveryapp.feature.category.di.domain.DomainBaseModule
import github.mik0war.deliveryapp.feature.category.di.presentation.PresentationBaseModule
import github.mik0war.deliveryapp.feature.category.presentation.CategoryListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataBaseModule::class,
    RetrofitModule::class,
    DomainBaseModule::class,
    PresentationBaseModule::class,
    DispatchersModule::class
])
interface CategoryComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): CategoryComponent
    }

    fun inject(fragment: CategoryListFragment)
}