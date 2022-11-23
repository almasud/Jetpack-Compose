package com.nybsys.jetpack_compose.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.nybsys.jetpack_compose.R
import com.nybsys.jetpack_compose.databinding.FragmentUserBinding

/**
 * A simple [Fragment] subclass.
 */
// Compose in XML
//class UserFragment : Fragment(R.layout.fragment_user) {
class UserFragment : Fragment() {
    // Compose in XML
//    private lateinit var binding: FragmentUserBinding

    // Compose in XML
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentUserBinding.bind(view)
//
//        binding.composeView.setContent {
//            UserListScreen()
//        }
//    }

    // Compose in Fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                UserListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserFragmentDefaultPreview() {
    UserListScreen()
}