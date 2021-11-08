package id.buaja.home.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import id.buaja.domain.model.Post

class DetailPostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            val bundle = this@DetailPostFragment.arguments
            val post = bundle?.getParcelable<Post>(POST)

            DetailPostScreen(
                post = post,
                navigationBack = {
                    findNavController().popBackStack()
                }
            )
        }
    }

    companion object {
        const val POST = "POST"
    }
}