package com.example.cinenowapp.list.presentation.di

import com.example.cinenowapp.list.data.local.LocalDataSource
import com.example.cinenowapp.list.data.local.MovieListLocalDataSource
import com.example.cinenowapp.list.data.remote.MovieListRemoteDataSource
import com.example.cinenowapp.list.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


class MovieListModule {
}

@Module
@InstallIn(ViewModelComponent::class)
interface MovieListModuleBinding {

    @Binds
    fun bindLocalDataSource(impl: MovieListLocalDataSource) : LocalDataSource

    @Binds
    fun bindRemoteDataSource(impl: MovieListRemoteDataSource) : RemoteDataSource
}