package com.tconnect.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF229ED9)
private val DeepBlue = Color(0xFF147DB5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TConnectApp() }
    }
}

@Composable
fun TConnectApp() {
    var phone by remember { mutableStateOf("+92") }
    var info by remember {
        mutableStateOf("TDLib connection is not configured yet. This is the starter UI.")
    }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Blue,
            secondary = DeepBlue,
            background = Color(0xFFF4F8FC)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Blue, DeepBlue)))
                .padding(22.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        color = Blue,
                        modifier = Modifier.size(76.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = "T-Connect",
                                tint = Color.White,
                                modifier = Modifier.size(38.dp)
                            )
                        }
                    }
                    Spacer(Modifier.height(18.dp))
                    Text("T-Connect", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = DeepBlue)
                    Text("Connect with your Telegram chats", color = Color(0xFF64748B))
                    Spacer(Modifier.height(28.dp))
                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone number") },
                        placeholder = { Text("+92 3XX XXXXXXX") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = {
                            info = "Starter screen only: TDLib authorization is not connected yet. Do not enter or send a real phone number in this demo."
                        },
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Continue", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    }
                    Spacer(Modifier.height(18.dp))
                    Text(info, color = Color(0xFF64748B), fontSize = 12.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("Unofficial third-party client concept", color = Color(0xFF94A3B8), fontSize = 11.sp)
                }
            }
        }
    }
}
