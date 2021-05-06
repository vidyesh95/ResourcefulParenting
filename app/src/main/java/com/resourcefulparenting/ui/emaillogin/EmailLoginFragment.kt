package com.resourcefulparenting.ui.emaillogin

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.resourcefulparenting.R

class EmailLoginFragment : Fragment() {

    companion object {
        fun newInstance() = EmailLoginFragment()
    }

    private lateinit var loginViewModel: EmailLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = ViewModelProvider(this).get(EmailLoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}