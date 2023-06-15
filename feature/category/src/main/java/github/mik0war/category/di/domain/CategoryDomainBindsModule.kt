package github.mik0war.category.di.domain

import dagger.Binds
import dagger.Module
import github.mik0war.category.domain.CategoryExceptionHandler
import github.mik0war.entity.DataMapper
import github.mik0war.entity.ExceptionHandler
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.category.Category
import github.mik0war.entity.dataModel.category.CategoryDataModel
import github.mik0war.recycler_list.data.GetDataListListRepositoryImpl
import github.mik0war.recycler_list.domain.GetDataListInteractor
import github.mik0war.recycler_list.domain.GetDataListRepository

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