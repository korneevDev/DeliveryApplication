package github.mik0war.deliveryapp.feature.shoppingCart.show.di

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.ExceptionHandler
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dishCounted.DishCounted
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedDataModel
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListDataSource
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListListRepositoryImpl
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListInteractor
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListRepository
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListLiveData
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel
import github.mik0war.deliveryapp.feature.shoppingCart.show.data.CacheGetDataListDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.show.domain.ShowShoppingCartExceptionHandler

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