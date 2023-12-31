package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.category.di.CategorySubComponentProvider
import github.mik0war.database_communication.di.FillShoppingCartSubComponent
import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.deliveryapp.di.DeliveryComponent
import github.mik0war.deliveryapp.di.DaggerDeliveryComponent
import github.mik0war.dish.di.DishSubComponent
import github.mik0war.dish.di.DishSubComponentProvider
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponent
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponentProvider

class DeliveryApp: Application(),
    CategorySubComponentProvider,
    FillShoppingCartSubComponentProvider,
    ShowShoppingCartSubComponentProvider,
    DishSubComponentProvider
{
    private val appComponent: DeliveryComponent by lazy {
        DaggerDeliveryComponent.factory().create(this)
    }

    override fun provideCategorySubComponent(): CategorySubComponent =
        appComponent.categorySubComponent().create()

    override fun provideFillShoppingCartSubComponent(): FillShoppingCartSubComponent =
        appComponent.fillCartSubComponent().create()

    override fun provideShowShoppingCartSubComponent(): ShowShoppingCartSubComponent =
        appComponent.shoppingCartSubComponent().create()

    override fun provideDishSubComponent(): DishSubComponent =
        appComponent.dishSubComponent().create()

}