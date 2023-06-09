package github.mik0war.deliveryapp.data

import github.mik0war.deliveryapp.core.data.TestCategoryService
import github.mik0war.deliveryapp.feature.category.core.NoConnectionException
import github.mik0war.deliveryapp.feature.category.core.ServiceUnavailableException
import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.MapperToCategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.cloud.CloudDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CloudDataSourceTest {

    @Test
    fun get_categories_test() = runTest {
        val cloudDataSource = CloudDataSource.Base(
            TestCategoryService(),
            MapperToCategoryDataModel()
        )

        val expected =
            listOf(
                CategoryDataModel(0, "test Model 1", "testImageUrl"),
                CategoryDataModel(1, "test model 2", "testImageUrl 2")
            )


        val actual = cloudDataSource.getCategories()

        assertEquals(expected, actual)

        try {
            cloudDataSource.getCategories()
        } catch(e: Exception){
            assert(e is NoConnectionException)
        }

        try {
            cloudDataSource.getCategories()
        } catch(e: Exception){
            assert(e is ServiceUnavailableException)
        }
    }
}