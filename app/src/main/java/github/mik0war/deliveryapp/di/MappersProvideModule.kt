package github.mik0war.deliveryapp.di

import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.entity.category.Category
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.entity.dish.Dish
import github.mik0war.deliveryapp.entity.dish.DishDataModel
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.entity.dishCounted.DishCounted
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedDataModel
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.entity.mapper.CategoryMapperTo
import github.mik0war.deliveryapp.entity.mapper.DishCountedMapperTo
import github.mik0war.deliveryapp.entity.mapper.DishMapperTo
import github.mik0war.deliveryapp.entity.mapper.MapperTo
import github.mik0war.deliveryapp.feature.shoppingCart.fill.data.cache.DishCacheModel
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class MappersProvideModule {

    @Singleton
    @Provides
    fun provideMapperToCategory(): MapperTo<Category> = object : CategoryMapperTo<Category> {
        override fun map(id: Int, name: String, imageUrl: String) =
            if (id == 0 && imageUrl.isEmpty())
                Category.Error(name)
            else
                Category.Success(id, name, imageUrl)
    }

    @Singleton
    @Provides
    fun provideMapperToCacheDataModel(): DishMapperTo<DishCacheModel> =
        object : DishMapperTo<DishCacheModel> {
            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ) = DishCacheModel(id, name, price, weight, description, image_url, tags)
        }

    @Singleton
    @Provides
    fun provideCountedMapperToCacheDataModel(): DishCountedMapperTo<DishCacheModel> =
        object : DishCountedMapperTo<DishCacheModel> {
            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) = DishCacheModel(id, name, price, weight, description, image_url, tags)
                .also { it.count = count }
        }

    @Singleton
    @Provides
    fun provideMapperToCategoryUIModel(): MapperTo<CategoryUIModel> =
        object : CategoryMapperTo<CategoryUIModel> {
            override fun map(id: Int, name: String, imageUrl: String) =
                if (id == 0 && imageUrl.isEmpty())
                    CategoryUIModel.Error(name)
                else
                    CategoryUIModel.Success(id, name, imageUrl)
        }

    @Singleton
    @Provides
    fun provideMapperToDishDataModel(): MapperTo<DishDataModel> =
        object : DishMapperTo<DishDataModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ) = DishDataModel(id, name, price, weight, description, image_url, tags)
        }

    @Singleton
    @Provides
    fun provideMapperToDish(): MapperTo<Dish> = object : DishMapperTo<Dish> {

        override fun map(
            id: Int,
            name: String,
            price: Int,
            weight: Int,
            description: String,
            image_url: String,
            tags: List<String>
        ): Dish =
            if (id == 0 && price == 0 && weight == 0 && description.isEmpty() &&
                image_url.isEmpty() && tags.isEmpty()
            )
                Dish.Error(name)
            else
                Dish.Success(id, name, price, weight, description, image_url, tags)
    }

    @Singleton
    @Provides
    fun provideMapperToDishUIModel(): MapperTo<DishUIModel> =
        object : DishMapperTo<DishUIModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>
            ): DishUIModel =
                if (id == 0 && price == 0 && weight == 0 && description.isEmpty() &&
                    image_url.isEmpty() && tags.isEmpty()
                )
                    DishUIModel.Error(name)
                else
                    DishUIModel.Success(id, name, price, weight, description, image_url, tags)
        }

    @Singleton
    @Provides
    fun provideMapperToDishCountedDataModel(): MapperTo<DishCountedDataModel> =
        object : DishCountedMapperTo<DishCountedDataModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) = DishCountedDataModel(id, name, price, weight, description, image_url, tags, count)
        }

    @Singleton
    @Provides
    fun provideMapperToDishCounted(): MapperTo<DishCounted> =
        object : DishCountedMapperTo<DishCounted> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) =
                if (id == 0 && price == 0 && weight == 0 && description.isEmpty() &&
                    image_url.isEmpty() && tags.isEmpty()
                )
                    DishCounted.Error(name)
                else
                    DishCounted.Success(id, name, price, weight, description, image_url, tags, count)
        }

    @Singleton
    @Provides
    fun provideMapperToDishCountedUIModel(): MapperTo<DishCountedUIModel> =
        object : DishCountedMapperTo<DishCountedUIModel> {

            override fun map(
                id: Int,
                name: String,
                price: Int,
                weight: Int,
                description: String,
                image_url: String,
                tags: List<String>,
                count: Int
            ) =
            if (price == 0 || weight == 0 || description.isEmpty() ||
            image_url.isEmpty()
            )
            DishCountedUIModel.Error(name)
            else
            DishCountedUIModel.Success(id, name, price, weight, description, image_url, tags, count)
        }
}
