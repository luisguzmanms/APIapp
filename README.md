# Documentación App API REST con MVVM "Clientes"

> Documentación y desarrollo móvil realizado por Luis A. Mesa ([luis4mesa@gmail.com](mailto:luisguzman014.m@gmail.com))

Introducción
============

El siguiente documento describe el desarrollo de una aplicación móvil con arquitectura **MVVM** que permite realizar una llamada a un **API REST** en la URL [https://jsonplaceholder.typicode.com/users](https://jsonplaceholder.typicode.com/users) para obtener información sobre usuarios denominados como clientes para este caso.

Los datos son luego cargados en un Recycler View, y se pueden filtrar para una mejor visualización y accesibilidad.

  

Tecnologías utilizadas
======================

Para el desarrollo de la aplicación se han utilizado las siguientes tecnologías:

  

*   **Android Studio**: Es el entorno para desarrollo de aplicaciones para Android.
*   Lenguaje de programación: **Kotlin**.
*   **Coroutines** de **Kotlin** para procesar tareas asíncronas.
*   Arquitectura **MVVM** para la implementación de la base de datos.
*   **DataBinding** para enlazar los datos del ViewModel con la interfaz.
*   **MaterialDesign3** para un diseño agradable.

  

Codigo fuente, Video e Instalador APK
=====================================

En esta sección se incluirá el código fuente completo de la aplicación, un video demostrativo para ver su funcionamiento y un instalador para descargar e instalar la aplicación.

  

*   Código Fuente: [Github](https://github.com/luisguzmanms/APIapp)
*   Demostración: [Video](https://rebrand.ly/CRUDvideo)
*   Instalador: [Descargar](https://rebrand.ly/CRUDapk)

  

Detalles del desarrollo
=======================

MVVM
----

se utiliza en este proyecto para separar la lógica de negocios de la lógica de la interfaz de usuario.

LiveData
--------

manejo de cambios en los datos y la actualización automática de la vista

Databinding
-----------

Vincular los datos directamente a la vista

  

  

  

  

  

![](https://t3128544.p.clickup-attachments.com/t3128544/ff0ea274-1976-4439-b688-b88997eb7f36/image.png)

  

Uso de MVVM
===========

  

*   [**CustomerAdapter**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/adapter/CustomerAdapter.kt): Se encarga de mostrar la información de cada cliente en la lista de clientes.
*   [**Customer**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/res/layout/customer_item.xml): Contiene las propiedades y métodos necesarios para representar a un cliente.
*   [**CustomerApiClient**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/api/CustomerApiClient.kt): archivo se encarga de establecer la conexión con la API que proporciona los datos de los clientes.
*   [**CustomerService**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/CustomerService.kt): Contiene funciones específicas para obtener los clientes.
*   [**RetrofitHelper**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/RetrofitHelper.kt)**:** facilita la creación de Retrofit.
*   [**CustomerRepository**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/repository/CustomerRepository.kt)[:](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/repository/CustomerRepository.kt) encargado de gestionar el acceso a los datos de los clientes desde la API.
*   [**CustomerViewHolder**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/ui/view/CustomerViewHolder.kt): Contiene la información que se mostrará para cada cliente.
*   [**MainActivity**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/ui/view/MainActivity.kt): actividad principal de la aplicación.
*   [**CustomerViewModel**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/ui/viewmodel/CustomerViewModel.kt): Obtiene los datos a través del repositorio y proporcionarlos a la actividad principal.
*   [**GetCustomersUseCase**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/usecase/GetCustomersUseCase.kt): caso de uso que proporciona la manera de obtener los clientes de la aplicación.
*   [**Util**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/util/Util.kt): contiene funciones útiles como la validación de conexión a internet.

  

![](https://t3128544.p.clickup-attachments.com/t3128544/3c73b060-bbf5-4957-b12f-2c1a3b0272e5/image.png)

  

Funcionamiento de la aplicación
===============================

Se hace una llamada API REST a [https://jsonplaceholder.typicode.com/users](https://jsonplaceholder.typicode.com/users) para obtener un listado de usuarios denominados "**clientes**", la información recibida se muestra en una vista de RecyclerView y se puede filtrar mediante una barra de búsqueda.

  

Implementación API REST:
------------------------

Para ello, se creó una clase llamada [`CustomerService`](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/CustomerService.kt) [](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/CustomerService.kt)que contiene la configuración de Retrofit para realizar la solicitud. haciendo uso del metodo "**GET**" [`CustomerApiClient`](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/api/CustomerApiClient.kt) [](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/network/api/CustomerApiClient.kt)para la consulta en la interfaz, con uso de **Courutines (**[Dispatchers.IO](http://Dispatchers.IO)**)** para la operaciones de datos en segundo plano.

```kotlin
class CustomerService {
    private val retrofit =     RetrofitHelper.getRetrofit("https://jsonplaceholder.typicode.com/")
    suspend fun getCustomers(): List<Customer> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CustomerApiClient::class.java).getAllCustomers()
            response.body() ?: emptyList()
        }
    }
}

interface CustomerApiClient {
    @GET("users")
    suspend fun getAllCustomers(): Response<List<Customer>>
}
```

  

Luego, se creó un **Repository**, que es el encargado de obtener los datos de la **API** y proporcionarlos a la **vista**. En este caso, se utilizaron **Coroutines** para manejar de manera asíncrona la solicitud y evitar bloqueos en la UI. [CustomerRepository](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/repository/CustomerRepository.kt)

[**CustomerRepository**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/repository/CustomerRepository.kt)

```kotlin
class CustomerRepository {

    private val api = CustomerService()

    suspend fun getCustomers(): List<Customer> {
        return api.getCustomers()
    }

}
```

  

Por último, en el **ViewModel** se hizo la llamada al **Repository** mediante un **caso de uso** (**GetCustomersUseCase()**) para obtener los datos y exponerlos en la vista.

[CustomerViewModel](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/ui/viewmodel/CustomerViewModel.kt)

```kotlin
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
```

  

Implementación RecyclerView:
----------------------------

[**Customer**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/data/model/Customer.kt)

Se crea la clase **Customer** que el modelo de cliente que se utilizará en la aplicación. Contiene las propiedades y métodos necesarios para representar al cliente.

```kotlin
package com.lamesa.apiapp.data.model

data class Customer(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)
/
data class Geo(
    val lat: String,
    val lng: String
)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)
```

  

**RecyclerView**

Se implementa la vista en el XML activity\_main.xml

```xml
 <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/customer_recycler_view"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
```

  

[**CustomerAdapter**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/adapter/CustomerAdapter.kt)

Se crea el **CustomerAdapter** que se encargará de mostrar la lista de clientes en el recyclerview El método `updateList` actualiza la lista de clientes y llama a `notifyDataSetChanged` para notificar al adaptador de que la lista ha cambiado. El método `filterList` filtra la lista de clientes y actualiza la lista con los clientes filtrados.

```kotlin
package com.lamesa.apiapp.adapter


class CustomerAdapter : RecyclerView.Adapter<CustomerViewHolder>() {

    private var listCustomer = ArrayList<Customer>()
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.customer_item, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = listCustomer[position]
        holder.bind(customer)
        setAnimation(holder, position)
    }

    override fun getItemCount(): Int {
        return listCustomer.size
    }

    internal fun updateList(customers: List<Customer>) {
        listCustomer.clear()
        listCustomer.addAll(customers)
        this.notifyDataSetChanged()
    }

    internal fun filterList(filteredCustomers: List<Customer>) {
        this.updateList(filteredCustomers)
        this.notifyDataSetChanged()
    }

    private fun setAnimation(holder: CustomerViewHolder, position: Int) {
        if (position > lastPosition) {
            val animation = AlphaAnimation(0f, 1f)
            animation.duration = 500
            animation.startOffset = 100 * position.toLong()
            holder.itemView.startAnimation(animation)
            lastPosition = position
        }
    }

}
```

  

[**CustomerViewHolder**](https://github.com/luisguzmanms/APIapp/blob/4fb3cd6e5e4e21f05af2ffbe7241cac7096563c0/app/src/main/java/com/lamesa/apiapp/ui/view/CustomerViewHolder.kt)

Se inicializa las vistas que representan los detalles de un cliente, como su ID, nombre, correo electrónico, nombre de usuario, sitio web, teléfono, nombre de la compañía y ciudad de residencia. y se enlaza los datos traidos de la api.

  

![](https://t3128544.p.clickup-attachments.com/t3128544/43e6fd1c-cd09-4376-814b-87ec78c0d794/image.png)

```kotlin
package com.lamesa.apiapp.ui.view

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
        name.text = customer.name
        username.text = customer.username
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
```

  

RecyclerView en MainActivity

Se inicializa el **RecyclerView** desde **MainActivity**

```kotlin
private fun initRecyclerView() {
        val customerRecyclerView = findViewById<RecyclerView>(R.id.customer_recycler_view)
        customerRecyclerView.layoutManager = LinearLayoutManager(this)
        customerAdapter = CustomerAdapter()
        customerRecyclerView.adapter = customerAdapter
    }
```

  

Implementación de la barra de búsqueda.
---------------------------------------

Se crea un **EditText** en el _activity\_main.xml_ que mediante un **_TextWatcher_** _se detecta el texto digitado y es apsado a la función_ **_`filterCustomers(searchtext)`_**

  

```kotlin
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
```

  

En el adaptador del **RecyclerView**, se usa la función `filterList ()` para actualizar la vista del recycler view:

```kotlin
 internal fun filterList(filteredCustomers: List<Customer>) {
        this.updateList(filteredCustomers)
        this.notifyDataSetChanged()
    }
```

  

===

Conclusión
==========

En esta documentación se presentó la implementación de una aplicación en Android Studio utilizando Kotlin y las siguientes tecnologías: Retrofit2, Coroutines, DataBinding y MaterialDesign3. con arquitectura MVVM, de Retrofit y Coroutines donde se crearon las clases correspondientes para el Repository, el ViewModel y la Vista.

  

La aplicación realiza una consulta a un API ([https://jsonplaceholder.typicode.com/users](https://jsonplaceholder.typicode.com/users)) para obtener una lista de usuarios, que luego se muestran en un RecyclerView.

Adicional, se implementó una barra de búsqueda permitiendo al usuario filtrar la lista de acuerdo a la información proporcionada.
