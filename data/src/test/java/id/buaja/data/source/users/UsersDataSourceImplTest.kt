package id.buaja.data.source.users

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import id.buaja.data.source.users.response.AlbumsResponse
import id.buaja.data.source.users.routes.UsersService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.Before
import org.junit.Test

class UsersDataSourceImplTest {

    private val albums = listOf(
        AlbumsResponse(
            id = 1,
            title = "title",
            userId = 1
        )
    )

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should get album by idUser success`() = runBlocking {
        // GIVEN
        val apiService = mock<UsersService> {
            onBlocking {
                getAlbumsByIdUser(1)
            } doReturn listOf(
                AlbumsResponse(
                    id = 1,
                    title = "title",
                    userId = 1
                )
            )
        }

        val remote = UsersDataSourceImpl(apiService, testDispatcher)

        // WHEN
        val getAlbums = remote.getAlbumsByIdUser(1)

        // THEN
        getAlbums.collect {
            it shouldBeEqualTo albums
        }
    }
}