package com.example.cinenowapp.di

import android.app.Application
import androidx.core.graphics.rotationMatrix
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cinenowapp.common.data.local.CineNowDataBase
import com.example.cinenowapp.common.data.local.MovieDao
import com.example.cinenowapp.common.data.remote.RetrofitClient
import com.example.cinenowapp.list.data.remote.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class MovieNowModule {
    @Provides
    fun providesCineNowDataBase(application: Application): CineNowDataBase {
        return Room.databaseBuilder(
            application.applicationContext,
            CineNowDataBase::class.java, "database-cine-now"
        ).build()
    }

    @Provides
    fun provideMovieDao(roomDatabase: CineNowDataBase): MovieDao {
        return roomDatabase.getMovieDao()
    }


    @Provides
    fun providesRetrofit(): Retrofit {
        return RetrofitClient.retrofitInstance
    }

    @Provides
    fun providesListService(retrofit: Retrofit): ListService {
        return retrofit.create(ListService::class.java)
    }

    @Provides
    @DispatcherIO
    fun providesDispatcherIO(): CoroutineDispatcher {
        return Dispatchers.IO
    }

}