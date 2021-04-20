package com.izwin.testwork.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.izwin.testwork.databinding.FragmentPaymentDetailBinding
import com.izwin.testwork.model.PaymentModel
import com.izwin.testwork.viewmodel.PaymentDetailViewModel


class PaymentDetailFragment : Fragment() {

    lateinit var viewmodel: PaymentDetailViewModel
    var model = PaymentModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewmodel = ViewModelProvider(this).get(PaymentDetailViewModel::class.java)
        viewmodel.model = model

        val binding = FragmentPaymentDetailBinding.inflate(inflater)
        binding.viewmodel = viewmodel

        return binding.root
    }
}