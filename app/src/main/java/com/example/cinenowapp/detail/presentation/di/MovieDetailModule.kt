package com.example.cinenowapp.detail.presentation.di

import com.example.cinenowapp.detail.data.DetailService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class MovieDetailModule {

    @Provides
    fun providesMovieDetailService(retrofit: Retrofit) : DetailService {
        return retrofit.create(DetailService::class.java)
    }
}