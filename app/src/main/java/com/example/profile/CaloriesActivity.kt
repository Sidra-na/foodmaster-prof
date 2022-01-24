package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class CaloriesActivity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var backButton: ImageView
    private lateinit var calText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_button)


        addButton=findViewById(R.id.add_button)
        backButton=findViewById(R.id.back_btn)
        calText=findViewById(R.id.calories_text)

        var calories:String=""


        addButton.setOnClickListener(View.OnClickListener {
            calories= calText.text.toString()
            val intent=Intent()
            intent.putExtra("Calories",calories)
            setResult(RESULT_OK,intent)
            finish()

        })
        backButton.setOnClickListener(View.OnClickListener {
          finish()
        })

    }
}