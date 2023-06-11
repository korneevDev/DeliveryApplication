package github.mik0war.deliveryapp.feature.internetData.core.di

import dagger.Module
import github.mik0war.deliveryapp.feature.internetData.category.di.CategorySubComponent
import github.mik0war.deliveryapp.feature.internetData.dish.di.DishSubComponent

@Module(subcomponents = [
    DishSubComponent::class,
    CategorySubComponent::class
])
class SubComponents