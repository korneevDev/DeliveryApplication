package github.mik0war.database_communication.di

import dagger.Binds
import dagger.Module
import github.mik0war.database_communication.data.FillCartRepositoryImpl
import github.mik0war.database_communication.data.cache.CacheDataSource
import github.mik0war.database.DishCacheModel
import github.mik0war.database_communication.domain.Interactor
import github.mik0war.database_communication.domain.FillCartRepository
import github.mik0war.database_communication.presentation.ShoppingCartFillViewModel
import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.dish.Dish
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.entity.dataModel.dishCounted.DishCounted
import github.mik0war.entity.dataModel.dishCounted.DishCountedDataModel
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel

@Module
abstract class FillCartBindsModule {
    @Binds
    abstract fun bindRepo(repository: FillCartRepositoryImpl<DishDataModel, DishCacheModel>):
            FillCartRepository<DishDataModel>

    @Binds
    abstract fun bindCacheDataSource(cacheDataSource: CacheDataSource.Base):
            CacheDataSource<DishCacheModel>
    @Binds
    abstract fun bindInteractor(interactor: Interactor.Base<Dish, DishDataModel>): Interactor<Dish>

    @Binds
    abstract fun bindVM(viewModel: ShoppingCartFillViewModel.Base<DishUIModel, Dish>):
            ShoppingCartFillViewModel<DishUIModel>



    @Binds
    abstract fun provideMapperDishToDataModel(
        mapper: DataMapper.Base<Dish, DishDataModel>
    ): DataMapper<Dish, DishDataModel>

    @Binds
    abstract fun provideMapperUIToDish(
        mapper: DataMapper.Base<DishUIModel, Dish>
    ): DataMapper<DishUIModel, Dish>


    @Binds
    abstract fun bindRepoCounted(repository: FillCartRepositoryImpl<DishCountedDataModel, DishCacheModel>):
            FillCartRepository<DishCountedDataModel>
    @Binds
    abstract fun bindInteractorCounted(interactor: Interactor.Base<DishCounted, DishCountedDataModel>):
            Interactor<DishCounted>

    @Binds
    abstract fun bindVMCounted(viewModel: ShoppingCartFillViewModel.Base<DishCountedUIModel, DishCounted>):
            ShoppingCartFillViewModel<DishCountedUIModel>


    @Binds
    abstract fun provideMapperDishToDataModelCounted(
        mapper: DataMapper.Base<DishCounted, DishCountedDataModel>
    ): DataMapper<DishCounted, DishCountedDataModel>

    @Binds
    abstract fun provideMapperUIToDishCounted(
        mapper: DataMapper.Base<DishCountedUIModel, DishCounted>
    ): DataMapper<DishCountedUIModel, DishCounted>
}