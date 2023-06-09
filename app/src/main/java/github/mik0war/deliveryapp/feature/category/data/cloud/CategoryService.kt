package github.mik0war.deliveryapp.feature.category.data.cloud

import retrofit2.http.GET

interface CategoryService {
    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategoriesObject() : CategoryListServerModel
}