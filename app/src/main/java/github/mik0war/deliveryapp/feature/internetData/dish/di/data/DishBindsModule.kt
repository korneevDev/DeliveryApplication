package github.mik0war.deliveryapp.feature.internetData.dish.di.data

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.ExceptionHandler
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.feature.internetData.core.data.CloudDataSource
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.internetData.core.data.InternetDataRepositoryImpl
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataInteractor
import github.mik0war.deliveryapp.feature.internetData.core.domain.InternetDataRepository
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataLiveData
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataViewModel
import github.mik0war.deliveryapp.feature.internetData.dish.data.DishCloudDataSource
import github.mik0war.deliveryapp.feature.internetData.dish.domain.DishExceptionHandler

@Module
abstract class DishBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: DishCloudDataSource):
            CloudDataSource<DishDataModel>

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

    @Binds
    abstract fun bindVM(viewModel: InternetDataViewModel.Base<Dish, DishUIModel>):
            InternetDataViewModel<DishUIModel>

    @Binds
    abstract fun bindLiveData(liveData: InternetDataLiveData.Base<DishUIModel>):
            InternetDataLiveData<DishUIModel>
}