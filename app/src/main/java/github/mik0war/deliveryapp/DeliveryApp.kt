package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.category.di.CategorySubComponentProvider
import github.mik0war.database_communication.di.FillShoppingCartSubComponent
import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.deliveryapp.di.DeliveryComponent
import github.mik0war.deliveryapp.di.DaggerDeliveryComponent

class DeliveryApp: Application(),
    CategorySubComponentProvider,
    FillShoppingCartSubComponentProvider {
    val appComponent: DeliveryComponent by lazy {
        DaggerDeliveryComponent.factory().create(this)
    }

    override fun provideCategorySubComponent(): CategorySubComponent =
        appComponent.categorySubComponent().create()

    override fun provideFillShoppingCartSubComponent(): FillShoppingCartSubComponent =
        appComponent.fillCartSubComponent().create()

}