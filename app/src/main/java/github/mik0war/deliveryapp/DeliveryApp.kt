package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.deliveryapp.feature.category.di.CategoryComponent
import github.mik0war.deliveryapp.feature.category.di.DaggerCategoryComponent

class DeliveryApp: Application() {
    val appComponent: CategoryComponent by lazy {
        DaggerCategoryComponent.factory().create(this)
    }
}