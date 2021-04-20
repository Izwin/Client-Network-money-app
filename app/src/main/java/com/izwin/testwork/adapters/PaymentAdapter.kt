package com.izwin.testwork.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izwin.testwork.R
import com.izwin.testwork.model.PaymentModel


class PaymentAdapter : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    var paymentList = ArrayList<PaymentModel>()
    lateinit var onPaymentClickListener: OnPaymentClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        return PaymentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.payment_item , parent , false))
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {

        val model = paymentList[position]
        holder.amount.text = if(model.amount?.length ?: 0 > 5 )model.amount?.substring(0,5) + "..." else  model.amount
        holder.created.text = model.created?.toString() ?: "???"
        holder.desc.text = if (model.desc?.length ?: 0 >13)model.desc!!.substring(0,10) + "..." else model.desc
        holder.currency.text = if(model.currency?.isEmpty() ?: true) "???" else model.currency
        holder.itemView.setOnClickListener{
            onPaymentClickListener.onItemClick(paymentList[position])
        }

    }

    override fun getItemCount(): Int {
        return  paymentList.size
    }

    class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var desc: TextView
        var amount: TextView
        var currency: TextView
        var created: TextView
        init {
            desc = itemView.findViewById(R.id.desc)
            amount = itemView.findViewById(R.id.amount)
            currency = itemView.findViewById(R.id.currency)
            created = itemView.findViewById(R.id.created)
        }
    }

}