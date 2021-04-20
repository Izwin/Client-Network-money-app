package com.izwin.testwork.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.izwin.testwork.BR
import com.izwin.testwork.R
import com.izwin.testwork.databinding.FragmentProfileBinding
import com.izwin.testwork.viewmodel.ProfileViewModel



class ProfileFragment : Fragment() {
    var viewmodel: ProfileViewModel = ProfileViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentProfileBinding.inflate(inflater)
        val view :View = inflater.inflate(R.layout.fragment_profile, container, false)
        viewmodel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.viewmodel = viewmodel

        binding.logOutButton.setOnClickListener {
            requireActivity().finish()
        }

        return binding.root
    }

}