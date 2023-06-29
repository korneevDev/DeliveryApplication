package github.mik0war.show_cart_list.di

import dagger.Module
import dagger.Provides
import github.mik0war.database.DishDataBase
import github.mik0war.database.GetDishDAO
import github.mik0war.entity.DataMapper
import github.mik0war.entity.dataModel.dish.Dish
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.entity.dataModel.mapper.MapperTo

@Module
class ShowCartProvidesModule {

    @Provides
    fun provideDAO(db: DishDataBase): GetDishDAO = db.getDishListDAO()

    @Provides
    fun provideDishDataMapper(
        mapper: MapperTo<Dish>
    ) = object : DataMapper<DishDataModel, Dish> {
        override fun map(dataObject: DishDataModel): Dish = dataObject.map(mapper)
    }

    @Provides
    fun provideMapperToUI(mapper: MapperTo<DishUIModel>) =
        object : DataMapper<Dish, DishUIModel> {
            override fun map(dataObject: Dish): DishUIModel =
                dataObject.map(mapper)
        }



}