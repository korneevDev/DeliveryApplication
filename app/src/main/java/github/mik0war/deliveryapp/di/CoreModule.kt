package github.mik0war.deliveryapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import github.mik0war.deliveryapp.feature.shoppingCart.core.DishDataBase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class CoreModule {
    @IODispatcher
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
    @MainDispatcher
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideRoom(context: Context): DishDataBase = Room.databaseBuilder(
        context,
        DishDataBase::class.java, "database-dish"
    ).build()


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher