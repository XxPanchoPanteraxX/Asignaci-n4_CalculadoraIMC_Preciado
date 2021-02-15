package preciado.francisco.asignacion4_calculadora_preciado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calcularButton)
        button.setOnClickListener {
            val resultadoView: TextView = findViewById(R.id.textResultado) as TextView
            resultadoView.text = calcularIMC().toString()

            val resultadoView2: TextView = findViewById(R.id.textResultadoRango) as TextView
            resultadoView2.text = calcularRango()

        }
    }

    fun calcularIMC(): Float {

        val altura : TextView = findViewById(R.id.AlturaText) as TextView;
        val peso : TextView = findViewById(R.id.pesoText) as TextView;

        var alturaFloat = (altura.text.toString()).toFloat();
        var pesoFloat = (peso.text.toString()).toFloat();
        var IMC =  pesoFloat/(alturaFloat * alturaFloat)

        return IMC;
    }

    fun calcularRango(): String {
        var imc = this.calcularIMC()

        if (imc < 18.5) {
            return "Bajo peso"
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Normal"
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso"
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidad grado 1"
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidad grado 2"
        }
            return "Obesidad grado 3"
    }

}