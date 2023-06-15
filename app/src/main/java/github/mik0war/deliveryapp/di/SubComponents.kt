package github.mik0war.deliveryapp.di

import dagger.Module
import github.mik0war.deliveryapp.feature.getListData.di.DishSubComponent
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponent

@Module(subcomponents = [
    DishSubComponent::class,
    github.mik0war.category.di.CategorySubComponent::class,
    github.mik0war.database_communication.di.FillShoppingCartSubComponent::class,
    ShowShoppingCartSubComponent::class
])
class SubComponents