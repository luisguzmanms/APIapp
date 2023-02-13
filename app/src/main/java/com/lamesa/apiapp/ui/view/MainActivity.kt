package com.lamesa.apiapp.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lamesa.apiapp.R
import com.lamesa.apiapp.adapter.CustomerAdapter
import com.lamesa.apiapp.data.model.Customer
import com.lamesa.apiapp.databinding.ActivityMainBinding
import com.lamesa.apiapp.ui.viewmodel.CustomerViewModel
import com.lamesa.apiapp.util.Util.isOnline

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var customerAdapter: CustomerAdapter
    private var allCustomers: List<Customer> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el ViewModel.
        initViewModel()
        // Inicializar el RecyclerView.
        initRecyclerView()
        // Inicializar los componentes de la vista.
        initBinding()
        // Cargar los clientes.
        loadCustomers()

    }

    private fun initViewModel() {
        customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        loadCustomers()
    }

    private fun initRecyclerView() {
        val customerRecyclerView = findViewById<RecyclerView>(R.id.customer_recycler_view)
        customerRecyclerView.layoutManager = LinearLayoutManager(this)
        customerAdapter = CustomerAdapter()
        customerRecyclerView.adapter = customerAdapter
    }

    private fun initBinding() {
        // Mostrar vista de cargando datos.
        binding.loadingData.visibility = View.VISIBLE
        // Detectar lista de Clientes
        customerViewModel.customers.observe(this) { listCustomers ->
            binding.loadingData.visibility = View.GONE
            allCustomers = listCustomers

            if (listCustomers.isNotEmpty()) {
                binding.cnEmpty.visibility = View.GONE
            } else {
                binding.cnEmpty.visibility = View.VISIBLE
            }

            // Mostrar número de clientes y actualizar lista.
            binding.counterCustomers.visibility = View.VISIBLE
            binding.counterCustomers.text = listCustomers.size.toString()
            customerAdapter.updateList(listCustomers)
        }
        // Detectar cambios en etSearch para el filtrado de clientes.
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val searchText = s.toString().trim().lowercase()
                // Filtrar los clientes.
                filterCustomers(searchText)
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                if (text.isEmpty()) {
                    customerAdapter.updateList(allCustomers)
                }
            }
        })
        // Botón para abrir la página web de GSE.
        binding.ivGse.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://gse.com.co/")
            startActivity(intent)
        }
    }


    // Función para filtrar los clientes de acuerdo a un texto dado.
    private fun filterCustomers(searchText: String) {
        val filteredCustomers = allCustomers.filter {
            it.id.toString().contains(searchText, ignoreCase = true)
                    || it.name.contains(searchText, ignoreCase = true)
                    || it.email.contains(searchText, ignoreCase = true)
                    || it.phone.contains(searchText, ignoreCase = true)
                    || it.website.contains(searchText, ignoreCase = true)
                    || it.address.city.contains(searchText, ignoreCase = true)
                    || it.company.name.contains(searchText, ignoreCase = true)
        }

        // Actualizar lista de RecyclerView.
        customerAdapter.filterList(filteredCustomers)

        // Indicar que no se encuentra ningún resultado.
        if (filteredCustomers.isEmpty()) {
            binding.cnEmpty.visibility = View.VISIBLE
            Toast.makeText(
                this@MainActivity,
                "No se encontraron resultados.",
                Toast.LENGTH_LONG
            ).show()
        } else {
            binding.cnEmpty.visibility = View.GONE
        }

    }

    // Función para detectar el cargue de clientes desde la api.
    private fun loadCustomers() {
        if (isOnline(this@MainActivity)) {
            customerViewModel.getCustomers()
        } else {
            binding.loadingData.visibility = View.GONE
            binding.cnEmpty.visibility = View.VISIBLE
            binding.tvEmpty.text = "Error conexión a internet."
        }
    }
}

