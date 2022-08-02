package com.example.spotify

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spotify.composables.CompostItem
import com.example.spotify.repository.songRepository

class MainActivity : ComponentActivity() {
    private lateinit var bluetoothManager: BluetoothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var takePermission: ActivityResultLauncher<String>
    private lateinit var takeResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter
        takePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                takeResultLauncher.launch(intent)
            } else {
                Toast.makeText(this, "Request not Granted", Toast.LENGTH_LONG).show()
            }
        }
        takeResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    Toast.makeText(this, "Bluetooth On", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Bluetooth Off", Toast.LENGTH_SHORT).show()
                }
            }
        setContent {
            val songRepository = songRepository()
            val allData = songRepository.getAllData()
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(items = allData) { index, item ->
                    Log.d("Visible", index.toString())
                    CompostItem(
                        song = item,
                        MediaPlayer.create(LocalContext.current, item.audioUrl), R.drawable.play,R.drawable.pause
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                FloatingActionButton(onClick = {
                        takePermission.launch(android.Manifest.permission.BLUETOOTH_CONNECT)
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.bluetooth),
                        contentDescription = "",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
            }
        }
    }
}





