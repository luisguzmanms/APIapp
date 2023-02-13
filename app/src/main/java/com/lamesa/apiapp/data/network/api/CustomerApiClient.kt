package com.lamesa.apiapp.data.network.api

import com.lamesa.apiapp.data.model.Customer
import retrofit2.Response
import retrofit2.http.GET

interface CustomerApiClient {

    @GET("users")
    suspend fun getAllCustomers(): Response<List<Customer>>

}
