package github.mik0war.deliveryapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.database_communication.di.FillShoppingCartSubComponent
import github.mik0war.dish.di.DishSubComponent
import github.mik0war.entity.di.MappersProvideModule
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    SubComponents::class,
    github.mik0war.database.di.CoreModule::class,
    MappersProvideModule::class
   ])
interface DeliveryComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): DeliveryComponent
    }

    fun categorySubComponent(): CategorySubComponent.Factory
    fun dishSubComponent(): DishSubComponent.Factory
    fun fillCartSubComponent(): FillShoppingCartSubComponent.Factory
    fun shoppingCartSubComponent(): ShowShoppingCartSubComponent.Factory

}