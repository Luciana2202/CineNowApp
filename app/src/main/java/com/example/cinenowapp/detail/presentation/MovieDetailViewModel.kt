package com.example.cinenowapp.detail.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.cinenowapp.common.data.remote.RetrofitClient
import com.example.cinenowapp.common.data.remote.model.MovieDto
import com.example.cinenowapp.detail.data.DetailService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val detailService: DetailService
) : ViewModel() {

    private val _uiMovie = MutableStateFlow<MovieDto?>(null)
    val uiMovie: StateFlow<MovieDto?> = _uiMovie

    fun fetchMovieDetail(movieId: String) {
        if (_uiMovie.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val response = detailService.getMovieById(movieId)
                if (response.isSuccessful) {
                    _uiMovie.value = response.body()
                } else {
                    Log.d(
                        "MovieDetailViewModel",
                        "Request Error :: ${response.errorBody()}"
                    )
                }
            }
        }
    }
}