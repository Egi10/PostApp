package id.buaja.users.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import id.buaja.users.R
import id.buaja.users.photo_details.PhotosDetailFragment

@AndroidEntryPoint
class UsersDetailFragment : Fragment() {
    private val viewModel by viewModels<UsersDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            val result = viewModel.uiState.collectAsState().value

            UsersDetailScreen(
                users = result,
                imageDetail = {
                    val bundle = Bundle()
                    bundle.putString(PhotosDetailFragment.IMAGE_DETAIL, it.thumbnail)
                    bundle.putString(PhotosDetailFragment.TITLE, it.title)
                    findNavController().navigate(
                        R.id.action_usersDetailFragment_to_photosDetailFragment,
                        bundle
                    )
                },
                onBack = {
                    findNavController().popBackStack()
                }
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this@UsersDetailFragment.arguments
        val userId = bundle?.getInt(USER_ID) ?: 0

        viewModel.getUser(userId)
    }

    companion object {
        const val USER_ID = "USER_ID"
    }
}