package github.mik0war.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import github.mik0war.database.DishDataBase
import github.mik0war.entity.di.IODispatcher
import github.mik0war.entity.di.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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