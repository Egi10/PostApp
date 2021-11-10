package id.buaja.users.photo_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class PhotosDetailFragment : Fragment() {

    private var imageDetail: String = ""
    private var title: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            PhotoDetailScreen(
                title = title,
                imageDetail = imageDetail
            ) {
                findNavController().popBackStack()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this@PhotosDetailFragment.arguments
        imageDetail = bundle?.getString(IMAGE_DETAIL) ?: ""
        title = bundle?.getString(TITLE) ?: ""
    }

    companion object {
        const val IMAGE_DETAIL = "USER_ID"
        const val TITLE = "TITLE"
    }
}