package github.mik0war.deliveryapp.di

import dagger.Module
import github.mik0war.deliveryapp.feature.getListData.dish.di.DishSubComponent
import github.mik0war.deliveryapp.feature.shoppingCart.fill.di.FillShoppingCartSubComponent
import github.mik0war.deliveryapp.feature.shoppingCart.show.di.ShowShoppingCartSubComponent

@Module(subcomponents = [
    DishSubComponent::class,
    github.mik0war.category.di.CategorySubComponent::class,
    FillShoppingCartSubComponent::class,
    ShowShoppingCartSubComponent::class
])
class SubComponents