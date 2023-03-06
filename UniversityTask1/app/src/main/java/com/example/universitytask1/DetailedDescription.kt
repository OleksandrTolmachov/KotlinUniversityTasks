package com.example.universitytask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.universitytask1.Animals.Animal

@Suppress("DEPRECATION")
class DetailedDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_description)

        val animal = intent.getParcelableExtra<Animal>("animal")

        val nameLabel = findViewById<TextView>(R.id.nameView)
        nameLabel.text = animal?.name

        val imageView = findViewById<ImageView>(R.id.imageView)
        val resId = resources.getIdentifier(animal?.image, "drawable", packageName)
        imageView.setImageResource(resId)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = animal?.description
    }
}