package github.mik0war.deliveryapp.feature.getListData.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.entity.ExceptionHandler
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.entity.category.CategoryDataModel
import github.mik0war.deliveryapp.feature.getListData.category.domain.CategoryExceptionHandler
import github.mik0war.deliveryapp.feature.getListData.core.data.GetDataListListRepositoryImpl
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListInteractor
import github.mik0war.deliveryapp.feature.getListData.core.domain.GetDataListRepository

@Module
abstract class CategoryDomainBindsModule {
    @Binds
    abstract fun bindRepository(
        repository: GetDataListListRepositoryImpl<CategoryDataModel>
    ): GetDataListRepository<CategoryDataModel>

    @Binds
    abstract fun bindInteractor(
        interactor: GetDataListInteractor.Base<CategoryDataModel, Category>
    ): GetDataListInteractor<Category>

    @Binds
    abstract fun bindExceptionHandler(
        exception: CategoryExceptionHandler
    ): ExceptionHandler<Category>

    @Binds
    abstract fun bindStringResourceManager(
        stringResourceProvider: StringResourceProvider.Base
    ): StringResourceProvider

    @Binds
    abstract fun bindMapperCategoryDataModelCategory(
        mapper: DataMapper.Base<CategoryDataModel, Category>
    ): DataMapper<CategoryDataModel, Category>
}