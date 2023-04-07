package com.example.universitytask1


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.universitytask1.Animals.Animal
import com.example.universitytask1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        binding.detailsButton1.setOnClickListener {
            onClickHandler(createAnimal
                ("platypus", "fd_platypus", "platypus"))
        }

        binding.detailsButton2.setOnClickListener {
            onClickHandler(createAnimal
                ("goblin_shark", "fd_goblin_shark", "shark"))
        }

        binding.detailsButton3.setOnClickListener {
            onClickHandler(createAnimal
                ("capybara", "fd_capybara", "capybara"))
        }
    }

    private fun onClickHandler(animal: Animal){
        val intent = Intent(this, DetailedDescription::class.java)

        intent.putExtra("animal", animal)
        startActivity(intent)
    }

    @SuppressLint("DiscouragedApi")
    private fun createAnimal(name: String, description: String, image: String): Animal{
        val res: Resources = resources

        val resNameId = res.getIdentifier(name, "string", packageName)
        val name: String = res.getString(resNameId)

        val resDescriptionId = res.getIdentifier(description, "string", packageName)
        val description: String = res.getString(resDescriptionId)

        return Animal(name, description, image)
    }
}
