package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.deliveryapp.feature.internetData.core.di.CategoryComponent
import github.mik0war.deliveryapp.feature.internetData.core.di.DaggerCategoryComponent

class DeliveryApp: Application() {
    val appComponent: CategoryComponent by lazy {
        DaggerCategoryComponent.factory().create(this)
    }
}