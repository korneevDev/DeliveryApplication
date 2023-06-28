package github.mik0war.entity.di

import dagger.Module
import dagger.Provides
import github.mik0war.entity.dataModel.category.Category
import github.mik0war.entity.dataModel.category.CategoryDataModel
import github.mik0war.entity.dataModel.category.CategoryUIModel
import github.mik0war.entity.dataModel.dish.Dish
import github.mik0war.entity.dataModel.dish.DishDataModel
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.entity.dataModel.dishCounted.DishCounted
import github.mik0war.entity.dataModel.dishCounted.DishCountedDataModel
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel
import github.mik0war.entity.dataModel.mapper.CategoryMapperTo
import github.mik0war.entity.dataModel.mapper.DishCountedMapperTo
import github.mik0war.entity.dataModel.mapper.DishMapperTo
import github.mik0war.entity.dataModel.mapper.MapperTo
import javax.inject.Singleton

@Module
class MappersProvideModule {

    @Singleton
    @Provides
    fun provideMapperToCategoryDataModel(): MapperTo<CategoryDataModel> =
        object : CategoryMapperTo<CategoryDataModel> {
            override fun map(id: Int, name: String, imageUrl: String) =
                CategoryDataModel(id, name, imageUrl)

            override fun mapError(name: String): CategoryDataModel = throw IllegalStateException()
        }
    @Singleton
    @Provides
    fun provideMapperToCategory(): MapperTo<Category> =
        object : CategoryMapperTo<Category> {
        override fun map(id: Int, name: String, imageUrl: String): Category =
            if (id == 0 && imageUrl.isEmpty())
                Category.Error(name)
            else
                Category.Success(id, name, imageUrl)

            override fun mapError(name: String): Category = Category.Error(name)
        }

    @Singleton
    @Provides
    fun provideMapperToCategoryUIModel(): MapperTo<CategoryUIModel> =
        object : CategoryMapperTo<CategoryUIModel> {
            override fun map(id: Int, name: String, imageUrl: String): CategoryUIModel =
                if (id == 0 && imageUrl.isEmpty())
                    CategoryUIModel.Error(name)
                else
                    CategoryUIModel.Success(id, name, imageUrl)

            override fun mapError(name: String): CategoryUIModel = CategoryUIModel.Error(name)
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

            override fun mapError(name: String): DishDataModel = throw IllegalStateException()
        }

    @Singleton
    @Provides
    fun provideMapperToDish(): MapperTo<Dish> =
        object : DishMapperTo<Dish> {

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

            override fun mapError(name: String): Dish = Dish.Error(name)
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

            override fun mapError(name: String): DishUIModel = DishUIModel.Error(name)
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

            override fun mapError(name: String): DishCountedDataModel = throw IllegalStateException()
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

            override fun mapError(name: String): DishCounted = DishCounted.Error(name)
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

            override fun mapError(name: String): DishCountedUIModel = DishCountedUIModel.Error(name)
        }
}
