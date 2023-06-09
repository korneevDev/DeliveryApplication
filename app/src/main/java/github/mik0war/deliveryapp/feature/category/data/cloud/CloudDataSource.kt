package github.mik0war.deliveryapp.feature.category.data.cloud

import android.util.Log
import github.mik0war.deliveryapp.feature.category.core.CategoryMapper
import github.mik0war.deliveryapp.feature.category.core.NoConnectionException
import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel
import java.net.UnknownHostException
import javax.inject.Inject

interface CloudDataSource{
    suspend fun getCategories(): List<CategoryDataModel>

    class Base @Inject constructor(
        private val categoryService: CategoryService,
        private val mapper: CategoryMapper<CategoryDataModel>
    ) : CloudDataSource {

        override suspend fun getCategories(): List<CategoryDataModel> =
            try {
                categoryService.getCategoriesObject()
                    .getCategoriesList().map { it.map(mapper) }
            } catch (e: Exception) {
                throw if (e is UnknownHostException)
                    NoConnectionException()
                else e.also { Log.e("kek", e.message?:"") }
            }
    }
}