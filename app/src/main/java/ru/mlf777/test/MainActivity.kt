package ru.mlf777.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, спасибо за делегирование мне '${property.name}'!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("POINT_0 $value было присвоено значению '${property.name} в $thisRef.'")
    }
}

class MainActivity : AppCompatActivity() {
    var p: String by Delegate()

    //ttt 22
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        p = "NEW"
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Log.d("POINT_0", "test $p")
        }
    }
}