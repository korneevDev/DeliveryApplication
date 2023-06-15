package github.mik0war.deliveryapp.feature.getListData.dish.di

import dagger.Binds
import dagger.Module
import github.mik0war.deliveryapp.feature.getListData.dish.tags.domain.TagInteractor
import github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation.TagsLiveData
import github.mik0war.deliveryapp.feature.getListData.dish.tags.presentation.TagsViewModel
import github.mik0war.entity.dataModel.dish.DishUIModel

@Module
abstract class TagsModule {
    @Binds
    abstract fun bindTagsVM(vm: TagsViewModel.Base<DishUIModel>): TagsViewModel<DishUIModel>

    @Binds
    abstract fun bindTagsLiveData(liveData: TagsLiveData.Base): TagsLiveData

    @Binds
    abstract fun bindTagsInteractor(interactor: TagInteractor.Base<DishUIModel>):
            TagInteractor<DishUIModel>

}