package id.buaja.home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import id.buaja.home.R
import id.buaja.home.ui.detail.DetailPostFragment

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            HomeScreen(viewModel = viewModel) {
                val bundle = Bundle()
                bundle.putParcelable(
                    DetailPostFragment.POST,
                    it
                )
                findNavController().navigate(
                    R.id.action_homeFragment_to_detailPostFragment,
                    bundle
                )
            }
        }
    }
}