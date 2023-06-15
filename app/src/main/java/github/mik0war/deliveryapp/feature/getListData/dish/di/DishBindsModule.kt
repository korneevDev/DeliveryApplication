package github.mik0war.deliveryapp.feature.getListData.dish.di

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.getListData.dish.data.DishCloudGetDataListDataSource
import github.mik0war.deliveryapp.feature.getListData.dish.data.DishServerModel
import github.mik0war.deliveryapp.feature.getListData.dish.domain.DishExceptionHandler
import github.mik0war.entity.DataMapper
import github.mik0war.entity.ExceptionHandler
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dish.Dish
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.recycler_list.data.GetDataListDataSource
import github.mik0war.recycler_list.data.GetDataListListRepositoryImpl
import github.mik0war.recycler_list.domain.GetDataListInteractor
import github.mik0war.recycler_list.domain.GetDataListRepository
import github.mik0war.recycler_list.presentation.GetDataListLiveData
import github.mik0war.recycler_list.presentation.GetDataListViewModel

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