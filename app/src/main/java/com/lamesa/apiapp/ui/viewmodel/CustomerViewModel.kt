package com.lamesa.apiapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamesa.apiapp.data.model.Customer
import com.lamesa.apiapp.usecase.GetCustomersUseCase
import kotlinx.coroutines.launch

class CustomerViewModel : ViewModel() {
    private val _customers = MutableLiveData<List<Customer>>()
    val getCustomersUseCase = GetCustomersUseCase()

    val customers: LiveData<List<Customer>>
        get() = _customers

    fun getCustomers() {
        viewModelScope.launch {
            val result = getCustomersUseCase()
            _customers.postValue(result)
        }
    }
}