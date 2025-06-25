package com.example.cinenowapp.list

import app.cash.turbine.test
import com.example.cinenowapp.common.data.local.MovieCategory
import com.example.cinenowapp.common.data.model.Movie
import com.example.cinenowapp.list.data.MovieListRepository
import com.example.cinenowapp.list.presentation.MovieListViewModel
import com.example.cinenowapp.list.presentation.ui.MovieListUiState
import com.example.cinenowapp.list.presentation.ui.MovieUiData
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock


class MovieListViewModelTest {

    private val repository: MovieListRepository = mock()
    private val testDispatcher = UnconfinedTestDispatcher(TestCoroutineScheduler())

    private val underTest by lazy {
        MovieListViewModel(repository, testDispatcher)
    }

    @Test
    fun `Given fresh viewModel when collecting to topRated then assert expected value`() {
        runTest {
            //Given
            val movies = listOf(
                Movie(
                    id = 1,
                    title = "title1",
                    overview = "overview1",
                    image = "image1",
                    category = MovieCategory.TopRated.name
                )
            )
            whenever(repository.getTopRated()).thenReturn(Result.success(movies))

            //when
            underTest.uiTopRated.test {
                // Then assert expected value
                val expected = MovieListUiState(
                    list = listOf(
                        MovieUiData(
                            id = 1,
                            title = "title1",
                            overview = "overview1",
                            image = "image1"
                        )
                    )
                )

                assertEquals(expected, awaitItem())
            }
        }
    }

    @Test
    fun `Given fresh viewModel when collecting to NowPlaying then assert expected value`() {
        runTest {
            //Given
            val movies = listOf(
                Movie(
                    id = 1,
                    title = "title1",
                    overview = "overview1",
                    image = "image1",
                    category = MovieCategory.NowPlaying.name
                )
            )
            whenever(repository.getNowPlaying()).thenReturn(Result.success(movies))

            //when
            underTest.uiNowPlaying.test {
                // Then assert expected value
                val expected = MovieListUiState(
                    list = listOf(
                        MovieUiData(
                            id = 1,
                            title = "title1",
                            overview = "overview1",
                            image = "image1"
                        )
                    )
                )

                assertEquals(expected, awaitItem())
            }
        }
    }

    @Test
    fun `Given fresh viewModel when collecting to popular then assert expected value`() {
        runTest {
            //Given
            val movies = listOf(
                Movie(
                    id = 1,
                    title = "title1",
                    overview = "overview1",
                    image = "image1",
                    category = MovieCategory.Popular.name
                )
            )
            whenever(repository.getPopular()).thenReturn(Result.success(movies))

            //when
            underTest.uiPopular.test {
                // Then assert expected value
                val expected = MovieListUiState(
                    list = listOf(
                        MovieUiData(
                            id = 1,
                            title = "title1",
                            overview = "overview1",
                            image = "image1"
                        )
                    )
                )

                assertEquals(expected, awaitItem())
            }
        }
    }

    @Test
    fun `Given fresh viewmodel When collecting to Upcoming Then assert expected value`() {
        runTest {
            val movies = listOf(
                Movie(
                    id = 1,
                    title = "title1",
                    overview = "overview1",
                    image = "image1",
                    category = MovieCategory.Upcoming.name
                )
            )
            whenever(repository.getUpcoming()).thenReturn(Result.success(movies))

            underTest.uiUpcoming.test {
                val expected = MovieListUiState(
                    list = listOf(
                        MovieUiData(
                            id = 1,
                            title = "title1",
                            overview = "overview1",
                            image = "image1",
                        )
                    )
                )

                assertEquals(expected, awaitItem())
            }
        }
    }

    @Test
    fun `Given fresh viewModel when collecting to topRated then assert loading state`() {
        runTest {
            //Given
            val movies = listOf(
                Movie(
                    id = 1,
                    title = "title1",
                    overview = "overview1",
                    image = "image1",
                    category = MovieCategory.TopRated.name
                )
            )
            whenever(repository.getTopRated()).thenReturn(Result.success(movies))

            //when
            val result = underTest.uiTopRated.value

            // Then assert expected value
            val expected = MovieListUiState( isLoading = true)

            assertEquals(expected, result)

        }
    }
}