package github.mik0war.deliveryapp

import android.app.Application
import github.mik0war.deliveryapp.feature.internetData.core.di.DeliveryComponent
import github.mik0war.deliveryapp.feature.internetData.core.di.DaggerDeliveryComponent

class DeliveryApp: Application() {
    val appComponent: DeliveryComponent by lazy {
        DaggerDeliveryComponent.factory().create(this)
    }
}