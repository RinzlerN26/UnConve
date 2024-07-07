package com.example.unconve

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unconve.ui.theme.UnConveTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnConveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var inputVal by remember { mutableStateOf("")}
    var outputVal by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Meters")}
    var outputUnit by remember { mutableStateOf("Meters")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}
    val convFactor = remember { mutableStateOf(1.00) }
    val oconvFactor = remember { mutableStateOf(1.00) }

    val customTextStyle=TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        color = Color.Blue
    )
    fun convUnit(){
        val inpValueDouble=inputVal.toDoubleOrNull()?:0.0
        val res=(inpValueDouble*convFactor.value*100.0/ oconvFactor.value).roundToInt()/100.0
        outputVal=res.toString()
    }
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("UnConve",style =
        // customTextStyle
        MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(16.dp))
         OutlinedTextField(value = inputVal, onValueChange ={
             inputVal=it
             convUnit()
            }, label = {Text("Enter Value")} )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                //Input Box
                Button(onClick={iExpanded= true }){
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="Arrow Down" )
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                    DropdownMenuItem(onClick = {
                        iExpanded=false
                        inputUnit="Centimeters"
                        convFactor.value=0.01
                        convUnit()
                    }) {
                        Text("Centimeters")
                    }
                    DropdownMenuItem(onClick = {
                        iExpanded=false
                        inputUnit="Meters"
                        convFactor.value=1.0
                        convUnit()}) {
                        Text("Meters")
                    }
                    DropdownMenuItem(onClick = {
                        iExpanded=false
                        inputUnit="Feet"
                        convFactor.value=0.3048
                        convUnit() }) {
                        Text("Feet")
                    }
                    DropdownMenuItem(onClick = {
                        iExpanded=false
                        inputUnit="Millimeters"
                        convFactor.value=0.001
                        convUnit() }) {
                        Text("Millimeters")
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                //Output Box
                Button(onClick={oExpanded= true }){
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="Arrow Down" )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false }) {
                    DropdownMenuItem(onClick = {
                        oExpanded=false
                        outputUnit="Centimeters"
                        oconvFactor.value=0.01
                        convUnit()
                    }) {
                        Text("Centimeters")
                    }
                    DropdownMenuItem(onClick = {  oExpanded=false
                        outputUnit="Meters"
                        oconvFactor.value=1.00
                        convUnit() }) {
                        Text("Meters")
                    }
                    DropdownMenuItem(onClick = {  oExpanded=false
                        outputUnit="Feet"
                        oconvFactor.value=0.3048
                        convUnit() }) {
                        Text("Feet")
                    }
                    DropdownMenuItem(onClick = {
                        oExpanded=false
                        outputUnit="Millimeters"
                        oconvFactor.value=0.001
                        convUnit() }) {
                        Text("Millimeters")
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $outputVal $outputUnit", style = MaterialTheme.typography.h5)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}