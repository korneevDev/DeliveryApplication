package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.deliveryapp.di.DeliveryComponent
import github.mik0war.deliveryapp.di.DaggerDeliveryComponent

class DeliveryApp: Application() {
    val appComponent: DeliveryComponent by lazy {
        DaggerDeliveryComponent.factory().create(this)
    }
}