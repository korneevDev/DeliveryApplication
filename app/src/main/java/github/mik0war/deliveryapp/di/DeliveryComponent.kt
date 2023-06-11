package github.mik0war.deliveryapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.deliveryapp.feature.internetData.category.di.CategorySubComponent
import github.mik0war.deliveryapp.feature.internetData.dish.di.DishSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    SubComponents::class,
    CoreModule::class
   ])
interface DeliveryComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): DeliveryComponent
    }

    fun categorySubComponent(): CategorySubComponent.Factory
    fun dishSubComponent(): DishSubComponent.Factory
}