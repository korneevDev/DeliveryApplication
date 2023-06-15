package github.mik0war.deliveryapp.feature.shoppingCart.di

import dagger.Binds
import dagger.Module
import github.mik0war.database.DishCacheModel
import github.mik0war.deliveryapp.feature.shoppingCart.data.CacheGetDataListDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.domain.ShowShoppingCartExceptionHandler
import github.mik0war.entity.DataMapper
import github.mik0war.entity.ExceptionHandler
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dishCounted.DishCounted
import github.mik0war.entity.dataModel.dishCounted.DishCountedDataModel
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel
import github.mik0war.recycler_list.data.GetDataListDataSource
import github.mik0war.recycler_list.data.GetDataListListRepositoryImpl
import github.mik0war.recycler_list.domain.GetDataListInteractor
import github.mik0war.recycler_list.domain.GetDataListRepository
import github.mik0war.recycler_list.presentation.GetDataListLiveData
import github.mik0war.recycler_list.presentation.GetDataListViewModel

@Module
abstract class ShowCartBindsModule {
    @Binds
    abstract fun bindGetDataListDataSource(cacheDataSource: CacheGetDataListDataSource<DishCountedDataModel>):
            GetDataListDataSource<DishCountedDataModel>

    @Binds
    abstract fun bindCloudDataSource(cacheDataSource: CacheGetDataListDataSource.Base<DishCountedDataModel>):
            CacheGetDataListDataSource<DishCountedDataModel>

    @Binds
    abstract fun bindRepository(
        repository: GetDataListListRepositoryImpl<DishCountedDataModel>
    ): GetDataListRepository<DishCountedDataModel>

    @Binds
    abstract fun bindInteractor(
        interactor: GetDataListInteractor.Base<DishCountedDataModel, DishCounted>
    ): GetDataListInteractor<DishCounted>

    @Binds
    abstract fun bindExceptionHandler(
        exception: ShowShoppingCartExceptionHandler
    ): ExceptionHandler<DishCounted>

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider

    @Binds
    abstract fun bindVM(viewModel: GetDataListViewModel.Base<DishCounted, DishCountedUIModel>):
            GetDataListViewModel<DishCountedUIModel>

    @Binds
    abstract fun bindLiveData(liveData: GetDataListLiveData.Base<DishCountedUIModel>):
            GetDataListLiveData<DishCountedUIModel>

    @Binds
    abstract fun bindMapperDishServerModelDishDataModel(
        mapper: DataMapper.Base<DishCacheModel, DishCountedDataModel>
    ): DataMapper<DishCacheModel, DishCountedDataModel>

    @Binds
    abstract fun bindMapperDishDataModelDish(
        mapper: DataMapper.Base<DishCountedDataModel, DishCounted>
    ): DataMapper<DishCountedDataModel, DishCounted>

    @Binds
    abstract fun bindMapperDishDishUIModel(
        mapper: DataMapper.Base<DishCounted, DishCountedUIModel>
    ): DataMapper<DishCounted, DishCountedUIModel>
}