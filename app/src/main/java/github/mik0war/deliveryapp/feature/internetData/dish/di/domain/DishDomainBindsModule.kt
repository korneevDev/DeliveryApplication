package github.mik0war.deliveryapp.feature.internetData.dish.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.feature.internetData.core.data.InternetDataRepositoryImpl
import github.mik0war.deliveryapp.feature.internetData.core.domain.ExceptionHandler
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataInteractor
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataRepository
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.feature.internetData.dish.domain.DishExceptionHandler

@Module
abstract class DishDomainBindsModule {
    @Binds
    abstract fun bindRepository(
        repository: InternetDataRepositoryImpl<DishDataModel>
    ): InternetDataRepository<DishDataModel>

    @Binds
    abstract fun bindInteractor(
        interactor: InternetDataInteractor.Base<DishDataModel, Dish>
    ): InternetDataInteractor<Dish>

    @Binds
    abstract fun bindExceptionHandler(
        exception: DishExceptionHandler
    ): ExceptionHandler<Dish>

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider
}