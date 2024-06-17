package com.example.my_flutter_app

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import com.unity3d.player.UnityPlayerActivity

class MainActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startUnityActivity()
    }

    private fun startUnityActivity() {
        val intent = Intent(this, UnityPlayerActivity::class.java)
        startActivity(intent)
    }
}
