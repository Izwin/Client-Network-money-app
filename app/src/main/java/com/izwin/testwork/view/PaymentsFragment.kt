package com.izwin.testwork.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izwin.testwork.R
import com.izwin.testwork.adapters.OnPaymentClickListener
import com.izwin.testwork.adapters.PaymentAdapter
import com.izwin.testwork.model.PaymentModel
import com.izwin.testwork.model.PaymentsResponseModel
import com.izwin.testwork.network.RetrofitInstance
import com.izwin.testwork.network.RetrofitService
import com.izwin.testwork.viewmodel.PaymentsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PaymentsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel:PaymentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_recycle_view, container, false)

        this.viewModel = ViewModelProvider(this).get(PaymentsViewModel::class.java)
        this.recyclerView = view.findViewById(R.id.rec_view)
        initRecycleView()

        return view
    }
    fun initRecycleView(){

        var myadapter = PaymentAdapter()
        object : OnPaymentClickListener{
            override fun onItemClick(model: PaymentModel) {

                val fragment = PaymentDetailFragment()
                fragment.model = model

                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_cont, fragment)
                    .commit()

            }
        }.also { myadapter.onPaymentClickListener = it }

        recyclerView.adapter = myadapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        RetrofitInstance.client
            .create(RetrofitService::class.java)
            .getPayments(viewModel.getCurrentToken())
            .enqueue(object : Callback<PaymentsResponseModel> {
                override fun onResponse(call: Call<PaymentsResponseModel>, response: Response<PaymentsResponseModel>) {
                    myadapter.paymentList = response.body()?.response as ArrayList<PaymentModel>
                    myadapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<PaymentsResponseModel>, t: Throwable) {
                }

            })
    }

}