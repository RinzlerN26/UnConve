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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unconve.ui.theme.UnConveTheme

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
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("UnConve")
        Spacer(modifier = Modifier.height(16.dp))
         OutlinedTextField(value = "", onValueChange ={} )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                Button(onClick={}){
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="Arrow Down" )
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Centimeters")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Meters")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Feet")
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick={}){
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription ="Arrow Down" )
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Centimeters")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Meters")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text("Feet")
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:")
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