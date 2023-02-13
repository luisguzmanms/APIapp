package com.lamesa.apiapp.usecase

import com.lamesa.apiapp.data.model.Customer
import com.lamesa.apiapp.data.repository.CustomerRepository

class GetCustomersUseCase {

    private val repository: CustomerRepository = CustomerRepository()

    suspend operator fun invoke(): List<Customer> {
        return repository.getCustomers()
    }

}