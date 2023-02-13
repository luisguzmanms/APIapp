package com.lamesa.apiapp.ui.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.lamesa.apiapp.R
import com.lamesa.apiapp.data.model.Customer

class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val cardCustomer = itemView.findViewById<MaterialCardView>(R.id.card_customer)
    private val id = itemView.findViewById<TextView>(R.id.identification)
    private val name = itemView.findViewById<TextView>(R.id.fullname)
    private val username = itemView.findViewById<TextView>(R.id.username)
    private val email = itemView.findViewById<TextView>(R.id.email)
    private val website = itemView.findViewById<TextView>(R.id.website)
    private val phone = itemView.findViewById<TextView>(R.id.phone)
    private val company = itemView.findViewById<TextView>(R.id.company)
    private val address = itemView.findViewById<TextView>(R.id.address)

    @SuppressLint("SetTextI18n")
    fun bind(customer: Customer) {
        id.text = "ID: ${customer.id}"
        name.text = "${customer.name}"
        username.text = "${customer.username}"
        email.text = customer.email
        phone.text = customer.phone
        website.text = customer.website
        company.text = customer.company.name
        address.text = customer.address.city

        cardCustomer.setOnClickListener() {
            Toast.makeText(cardCustomer.context, customer.toString(), Toast.LENGTH_SHORT).show()
        }

    }

}
