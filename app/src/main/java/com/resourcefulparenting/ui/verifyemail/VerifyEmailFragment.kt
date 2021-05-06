package com.resourcefulparenting.ui.verifyemail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.resourcefulparenting.R

class VerifyEmailFragment : Fragment() {

    companion object {
        fun newInstance() = VerifyEmailFragment()
    }

    private lateinit var viewModel: VerifyEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verify_email, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VerifyEmailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}