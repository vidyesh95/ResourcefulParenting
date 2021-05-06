package com.resourcefulparenting.ui.emailotp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.resourcefulparenting.R

class EmailOtpFragment : Fragment() {

    companion object {
        fun newInstance() = EmailOtpFragment()
    }

    private lateinit var viewModel: EmailOtpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email_otp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmailOtpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}