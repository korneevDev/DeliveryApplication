package github.mik0war.category.data

import retrofit2.http.GET

interface CategoryService {
    @GET("v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getListObject() : CategoryListServerModel
}