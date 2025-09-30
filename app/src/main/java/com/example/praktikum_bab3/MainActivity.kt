package com.example.praktikum_bab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AllAppsDisplay()
                }
            }
        }
    }
}

@Composable
fun AllAppsDisplay() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // counter
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            CounterAppSection()
        }

        // color toggle
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            ColorToggleAppSection()
        }

        // interactive profile
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            InteractiveProfileAppSection()
        }
    }
}

@Composable
fun CounterAppSection() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = count.toString(),
            fontSize = 72.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    if (count > 0) count--
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935)
                ),
                modifier = Modifier.size(100.dp, 56.dp)
            ) {
                Text(
                    text = "−",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF43A047)
                ),
                modifier = Modifier.size(100.dp, 56.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (count == 0) {
            Text(
                text = "Nilai tidak bisa kurang dari 0",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ColorToggleAppSection() {
    var isRed by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Klik Kotak untuk Toggle Warna",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    color = if (isRed) Color.Red else Color.Green,
                    shape = MaterialTheme.shapes.medium
                )
                .clickable { isRed = !isRed },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isRed) "MERAH" else "HIJAU",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Warna saat ini: ${if (isRed) "Merah" else "Hijau"}",
            fontSize = 16.sp,
            color = if (isRed) Color.Red else Color.Green,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun InteractiveProfileAppSection() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // profile image
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Filzah Mufidah",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Mahasiswa Teknik Informatika",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "NIM: 235150207111074",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { isFollowed = !isFollowed },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowed) Color.Gray else Color(0xFF6200EA)
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        ) {
            Text(
                text = if (isFollowed) "Unfollow" else "Follow",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isFollowed)
                    Color(0xFFE8F5E9)
                else
                    Color(0xFFFFF3E0)
            )
        ) {
            Text(
                text = if (isFollowed)
                    "✓ Anda mengikuti akun ini"
                else
                    "○ Anda belum mengikuti akun ini",
                fontSize = 14.sp,
                modifier = Modifier.padding(16.dp),
                color = if (isFollowed) Color(0xFF2E7D32) else Color(0xFFE65100),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("Posts", "42")
            StatItem("Followers", if (isFollowed) "101" else "100")
            StatItem("Following", "89")
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AllAppsPreview() {
    MaterialTheme {
        AllAppsDisplay()
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MaterialTheme {
        CounterAppSection()
    }
}

@Preview(showBackground = true)
@Composable
fun ColorTogglePreview() {
    MaterialTheme {
        ColorToggleAppSection()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    MaterialTheme {
        InteractiveProfileAppSection()
    }
}