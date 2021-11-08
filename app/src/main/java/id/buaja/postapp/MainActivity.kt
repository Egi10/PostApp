package id.buaja.postapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.buaja.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}