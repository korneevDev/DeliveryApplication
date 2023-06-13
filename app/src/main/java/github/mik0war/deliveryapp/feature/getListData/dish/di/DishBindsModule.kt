package github.mik0war.deliveryapp.feature.getListData.dish.di

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.ExceptionHandler
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListDataSource
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListListRepositoryImpl
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListInteractor
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListRepository
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListLiveData
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel
import github.mik0war.deliveryapp.feature.getListData.dish.data.DishCloudGetDataListDataSource
import github.mik0war.deliveryapp.feature.getListData.dish.data.DishServerModel
import github.mik0war.deliveryapp.feature.getListData.dish.domain.DishExceptionHandler

@Module
abstract class DishBindsModule {
    @Binds
    abstract fun bindCloudDataSource(cloudDataSource: DishCloudGetDataListDataSource):
            GetDataListDataSource<DishDataModel>

    @Binds
    abstract fun bindRepository(
        repository: GetDataListListRepositoryImpl<DishDataModel>
    ): GetDataListRepository<DishDataModel>

    @Binds
    abstract fun bindInteractor(
        interactor: GetDataListInteractor.Base<DishDataModel, Dish>
    ): GetDataListInteractor<Dish>

    @Binds
    abstract fun bindExceptionHandler(
        exception: DishExceptionHandler
    ): ExceptionHandler<Dish>

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider

    @Binds
    abstract fun bindVM(viewModel: GetDataListViewModel.Base<Dish, DishUIModel>):
            GetDataListViewModel<DishUIModel>

    @Binds
    abstract fun bindLiveData(liveData: GetDataListLiveData.Base<DishUIModel>):
            GetDataListLiveData<DishUIModel>

    @Binds
    abstract fun bindMapperDishServerModelDishDataModel(
        mapper: DataMapper.Base<DishServerModel, DishDataModel>
    ): DataMapper<DishServerModel, DishDataModel>

    @Binds
    abstract fun bindMapperDishDataModelDish(
        mapper: DataMapper.Base<DishDataModel, Dish>
    ): DataMapper<DishDataModel, Dish>

    @Binds
    abstract fun bindMapperDishDishUIModel(
        mapper: DataMapper.Base<Dish, DishUIModel>
    ): DataMapper<Dish, DishUIModel>
}