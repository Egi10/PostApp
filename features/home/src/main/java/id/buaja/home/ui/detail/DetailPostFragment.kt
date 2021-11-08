package id.buaja.home.ui.detail

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
import id.buaja.domain.model.Post

@AndroidEntryPoint
class DetailPostFragment : Fragment() {
    private val viewModel by viewModels<DetailPostViewModel>()

    private lateinit var post: Post

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            val result = viewModel.uiState.collectAsState().value

            DetailPostScreen(
                post = post,
                comments = result.data ?: emptyList(),
                contentError = {
                    LoadingAndErrorItem(result)
                },
                navigationBack = {
                    findNavController().popBackStack()
                }
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this@DetailPostFragment.arguments
        post = bundle?.getParcelable<Post>(POST) as Post

        viewModel.getPostComment(post.id)
    }

    companion object {
        const val POST = "POST"
    }
}