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