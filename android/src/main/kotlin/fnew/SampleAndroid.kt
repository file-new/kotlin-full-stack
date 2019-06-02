package fnew

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fnew.shared.hello


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.main_text).text = hello()
    }
}