package com.resourcefulparenting.ui.emailotp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.resourcefulparenting.databinding.FragmentEmailOtpBinding

class EmailOtpFragment : Fragment() {

    companion object {
        fun newInstance() = EmailOtpFragment()
    }

    private lateinit var viewModel: EmailOtpViewModel
    private var _binding: FragmentEmailOtpBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailOtpBinding.inflate(inflater, container, false)
        val view: View = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmailOtpViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}