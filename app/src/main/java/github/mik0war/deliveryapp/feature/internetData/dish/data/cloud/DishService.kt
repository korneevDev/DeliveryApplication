package github.mik0war.deliveryapp.feature.internetData.dish.data.cloud

import retrofit2.http.GET

interface DishService {
    @GET("v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getListObject() : DishListServerModel
}