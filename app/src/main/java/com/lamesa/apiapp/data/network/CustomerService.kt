package com.lamesa.apiapp.data.network

import com.lamesa.apiapp.data.model.Customer
import com.lamesa.apiapp.data.network.api.CustomerApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CustomerService {

    private val retrofit = RetrofitHelper.getRetrofit("https://jsonplaceholder.typicode.com/")

    suspend fun getCustomers(): List<Customer> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CustomerApiClient::class.java).getAllCustomers()
            response.body() ?: emptyList()
        }
    }

}