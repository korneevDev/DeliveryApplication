package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.category.di.CategorySubComponentProvider
import github.mik0war.deliveryapp.di.DeliveryComponent
import github.mik0war.deliveryapp.di.DaggerDeliveryComponent

class DeliveryApp: Application(), CategorySubComponentProvider {
    val appComponent: DeliveryComponent by lazy {
        DaggerDeliveryComponent.factory().create(this)
    }

    override fun provideCategorySubComponent(): CategorySubComponent =
        appComponent.categorySubComponent().create()
}