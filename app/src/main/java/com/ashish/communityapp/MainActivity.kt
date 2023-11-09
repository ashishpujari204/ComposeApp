package com.ashish.communityapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.communityapp.ui.theme.CommunityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommunityAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                    MobileInputField("Please enter your mobile number.", modifier)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileInputField(placeHolder: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var mobileNumberInput = remember {
            mutableStateOf(TextFieldValue())
        }
        OutlinedTextField(
            value = mobileNumberInput.value,
            onValueChange = {
                if (it.text.length <= 10) {
                    mobileNumberInput.value = it
                }
            },
            placeholder = { Text(text = placeHolder, color = Color.Black) },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        val context = LocalContext.current
        Button(
            modifier = Modifier.padding(top = 10.dp),
            onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
            enabled = mobileNumberInput.value.text.length == 10,
        ) {
            Text(text = "Submit", color = Color.White)
        }
    }
}