package com.lamesa.apiapp.data.repository

import com.lamesa.apiapp.data.model.Customer
import com.lamesa.apiapp.data.network.CustomerService

class CustomerRepository {

    private val api = CustomerService()

    suspend fun getCustomers(): List<Customer> {
        return api.getCustomers()
    }

}