
package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class WeightActivity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var backButton: ImageView
    private lateinit var weightText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewbutton)

        addButton=findViewById(R.id.weight_button)
        backButton=findViewById(R.id.back2_btn)
        weightText=findViewById(R.id.weight_txt)


        var weight:String=""


        addButton.setOnClickListener(View.OnClickListener {
            weight= weightText.text.toString()
            val intent= Intent()
            intent.putExtra("Weight",weight)
            setResult(RESULT_OK,intent)
            finish()

        })
        backButton.setOnClickListener(View.OnClickListener {

           finish()
        })


    }
}