package github.mik0war.deliveryapp.core.data

import github.mik0war.deliveryapp.feature.category.data.cloud.CategoryListServerModel
import github.mik0war.deliveryapp.feature.category.data.cloud.CategoryServerModel
import github.mik0war.deliveryapp.feature.category.data.cloud.CategoryService
import java.io.IOException
import java.net.UnknownHostException

class TestCategoryService : CategoryService {
    var iterator = 0

    override suspend fun getCategoriesObject(): CategoryListServerModel =
        when (iterator) {
            0 -> {
                iterator++
                CategoryListServerModel(
                    listOf(
                        CategoryServerModel(0, "test Model 1", "testImageUrl"),
                        CategoryServerModel(1, "test model 2", "testImageUrl 2")
                    )
                )
            }

            1 -> {
                iterator++
                throw UnknownHostException()
            }

            else -> {
                iterator = 0
                throw IOException()
            }
        }


}