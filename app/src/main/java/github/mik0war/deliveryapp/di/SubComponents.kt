package github.mik0war.deliveryapp.di

import dagger.Module
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.database_communication.di.FillShoppingCartSubComponent
import github.mik0war.dish.di.DishSubComponent
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponent

@Module(subcomponents = [
    DishSubComponent::class,
    CategorySubComponent::class,
    FillShoppingCartSubComponent::class,
    ShowShoppingCartSubComponent::class
])
class SubComponents