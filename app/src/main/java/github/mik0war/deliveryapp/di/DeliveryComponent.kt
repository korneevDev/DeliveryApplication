package github.mik0war.deliveryapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import github.mik0war.deliveryapp.feature.getListData.dish.di.DishSubComponent
import github.mik0war.deliveryapp.feature.shoppingCart.fill.di.FillShoppingCartSubComponent
import github.mik0war.deliveryapp.feature.shoppingCart.show.di.ShowShoppingCartSubComponent
import github.mik0war.entity.di.MappersProvideModule
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

    fun categorySubComponent(): github.mik0war.category.di.CategorySubComponent.Factory
    fun dishSubComponent(): DishSubComponent.Factory
    fun fillCartSubComponent(): FillShoppingCartSubComponent.Factory
    fun shoppingCartSubComponent(): ShowShoppingCartSubComponent.Factory

}