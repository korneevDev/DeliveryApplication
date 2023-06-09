package github.mik0war.deliveryapp.feature.category.di

import dagger.Component
import github.mik0war.deliveryapp.feature.category.di.data.DataBaseModule
import github.mik0war.deliveryapp.feature.category.di.data.RetrofitModule
import github.mik0war.deliveryapp.feature.category.di.domain.DomainBaseModule

@Component(modules = [
    DataBaseModule::class,
    RetrofitModule::class,
    DomainBaseModule::class])
interface CategoryComponent