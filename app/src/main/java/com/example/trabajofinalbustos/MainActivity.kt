package com.example.trabajofinalbustos

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.trabajofinalbustos.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener {

            comparar()
        }
    }

    private fun comparar() {

        val texto1 = editText1.text.toString()
        val texto2 = editText2.text.toString()

        if (texto1 == texto2) {
            textView.text = "Las cadenas son iguales"
        } else {
            textView.text = "Las cadenas son diferentes"
        }
    }
}
class Comparador {

    fun comparar(cadena1: String, cadena2: String): Boolean {
        return cadena1 == cadena2
    }
}

class ComparadorViewModel : ViewModel() {

    val resultado = MutableLiveData<Boolean>()

    fun actualizarResultado(cadena1: String, cadena2: String) {
        val comparador = Comparador()
        resultado.value = comparador.comparar(cadena1, cadena2)
    }
}

button.setOnClickListener {
    val texto1 = editText1.text.toString()
    val texto2 = editText2.text.toString()
    val comparadorViewModel = ComparadorViewModel()
    comparadorViewModel.actualizarResultado(texto1, texto2)
}

comparadorViewModel.resultado.observe(this, Observer { resultado ->
    if (resultado) {
        textView.text = "Las cadenas son iguales"
    } else {
        textView.text = "Las cadenas son diferentes"
    }
})
class ComparadorTest : TestCase() {

    fun testComparar() {

        val comparador = Comparador()

        assertTrue(comparador.comparar("hola", "hola"))

        assertFalse(comparador.comparar("hola", "adios"))

        assertFalse(comparador.comparar("hola", "holas"))

        assertFalse(comparador.comparar("hola", "HOLA"))
    }
}
class ComparadorUiTest : ActivityScenarioRule<MainActivity>(MainActivity::class.java) {


    fun testUi() {

        onView(withId(R.id.editText1)).perform(typeText("hola"))
        onView(withId(R.id.editText2)).perform(typeText("hola"))

        onView(withId(R))
    }
}