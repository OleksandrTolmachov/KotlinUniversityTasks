package com.example.universitytask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_description)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val image = intent.getStringExtra("image")

        val nameLabel = findViewById<TextView>(R.id.nameView)
        nameLabel.text = name

        val imageView = findViewById<ImageView>(R.id.imageView)
        val resId = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resId)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = description
    }
}