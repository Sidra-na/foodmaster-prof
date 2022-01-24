package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class EditInfoActivity : AppCompatActivity() {
    private lateinit var editNameText:EditText
    private lateinit var back:ImageView
    private lateinit var editButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_info)

        editNameText=findViewById(R.id.edit_name)
        back=findViewById(R.id.imageView_back)
        editButton=findViewById(R.id.edit_btn)
        editButton.setOnClickListener(View.OnClickListener {
            val editName=editNameText.text.toString()
            val intent=Intent()
            intent.putExtra("EditedName",editName)
            setResult(RESULT_OK,intent)
            finish()
        })
        back.setOnClickListener(View.OnClickListener {

           finish()
        })
    }
}