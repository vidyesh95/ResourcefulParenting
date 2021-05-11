package com.resourcefulparenting.ui.emaillogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.resourcefulparenting.databinding.FragmentEmailLoginBinding

class EmailLoginFragment : Fragment() {

    companion object {
        fun newInstance() = EmailLoginFragment()
    }

    private lateinit var loginViewModel: EmailLoginViewModel
    private var _binding: FragmentEmailLoginBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailLoginBinding.inflate(inflater, container, false)
        val view: View = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = ViewModelProvider(this).get(EmailLoginViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}