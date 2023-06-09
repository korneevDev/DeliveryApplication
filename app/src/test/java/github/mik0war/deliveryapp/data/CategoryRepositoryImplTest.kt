package github.mik0war.deliveryapp.data

import github.mik0war.deliveryapp.core.data.TestCategoryService
import github.mik0war.deliveryapp.feature.category.core.NoConnectionException
import github.mik0war.deliveryapp.feature.category.core.ServiceUnavailableException
import github.mik0war.deliveryapp.feature.category.data.CategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.CategoryRepositoryImpl
import github.mik0war.deliveryapp.feature.category.data.MapperToCategoryDataModel
import github.mik0war.deliveryapp.feature.category.data.cloud.CloudDataSource
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class CategoryRepositoryImplTest {
    @Test
    fun `get categories test`() = runTest {
        val repository = CategoryRepositoryImpl(
            CloudDataSource.Base(TestCategoryService(), MapperToCategoryDataModel()),
            StandardTestDispatcher(testScheduler)
        )

        val expected =
            listOf(
                CategoryDataModel(0, "test Model 1", "testImageUrl"),
                CategoryDataModel(1, "test model 2", "testImageUrl 2")
            )


        val actual = repository.getCategoryList()

        Assert.assertEquals(expected, actual)

        try {
            repository.getCategoryList()
        } catch(e: Exception){
            assert(e is NoConnectionException)
        }

        try {
            repository.getCategoryList()
        } catch(e: Exception){
            assert(e is ServiceUnavailableException)
        }
    }
}