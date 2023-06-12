package github.mik0war.deliveryapp.feature.shoppingCart.fill.di

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.RepositoryImpl
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.CacheDataSource
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel
import github.mik0war.deliveryapp.feature.shoppingCart.fill.domain.Interactor
import github.mik0war.deliveryapp.feature.shoppingCart.fill.domain.Repository
import github.mik0war.deliveryapp.feature.shoppingCart.fill.presentation.ShoppingCartFillViewModel

@Module
abstract class FillCartBindsModule {
    @Binds
    abstract fun bindRepo(repository: RepositoryImpl<DishDataModel, DishCacheModel>):
            Repository<DishDataModel>

    @Binds
    abstract fun bindCacheDataSource(cacheDataSource: CacheDataSource.Base):
            CacheDataSource<DishCacheModel>
    @Binds
    abstract fun bindInteractor(interactor: Interactor.Base<Dish, DishDataModel>): Interactor<Dish>

    @Binds
    abstract fun bindVM(viewModel: ShoppingCartFillViewModel.Base<DishUIModel, Dish>):
            ShoppingCartFillViewModel<DishUIModel>

    @Binds
    abstract fun provideMapperDataModelToCacheModel(
        mapper: DataMapper.Abstract<DishDataModel, DishCacheModel>
    ): DataMapper<DishDataModel, DishCacheModel>

    @Binds
    abstract fun provideMapperDishToDataModel(
        mapper: DataMapper.Abstract<Dish, DishDataModel>
    ): DataMapper<Dish, DishDataModel>

    @Binds
    abstract fun provideMapperUIToDish(
        mapper: DataMapper.Abstract<DishUIModel, Dish>
    ): DataMapper<DishUIModel, Dish>

}