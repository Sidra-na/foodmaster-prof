package com.example.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var addButton:Button
    private lateinit var viewButton:Button
    private lateinit var incButton: Button
    private lateinit var decButton: Button
    private lateinit var editProfileInfo:ImageView
    private lateinit var editProfilePic:ImageView
    private lateinit var glassesText: TextView
    private lateinit var calText:TextView
    private lateinit var weightText:TextView
    private lateinit var userNameText:TextView


    var  glassesNumber:Int =0
    val picImagesNum=100
    private var imageUri: Uri? = null



    private val secondActivityWithResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            if (result.data?.hasExtra("Calories")!!){
               val res=result.data!!.extras?.getString("Calories") ?: "No Result Provided"
                calText.text = res +" cal"
            }

        }
    }

    private val secondActivityWithResult2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            if (result.data?.hasExtra("Weight")!!){
                val res = result.data!!.extras?.getString("Weight") ?: "No Result Provided" + " Kg"
                weightText.text=res+" Kg"

            }
        }
    }

    private val secondActivityWithResult3 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            if (result.data?.hasExtra("EditedName")!!){
                val res=result.data!!.extras?.getString("EditedName") ?: "No Result Provided"
                userNameText.text = res
            }

        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton=findViewById(R.id.button_add)
        viewButton=findViewById(R.id.button_view)
        incButton=findViewById(R.id.button_inc)
        decButton=findViewById(R.id.button_dec)
        editProfileInfo=findViewById(R.id.edit_info)
        glassesText=findViewById(R.id.glasses_num)
        weightText=findViewById(R.id.weight_text)
        calText=findViewById(R.id.cal_text)
        userNameText=findViewById(R.id.user_name)
        editProfilePic=findViewById(R.id.profile_pic)

        editProfilePic.setOnClickListener(View.OnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, picImagesNum)
        })



        viewButton.setOnClickListener(View.OnClickListener {

            secondActivityWithResult.launch(Intent(this,CaloriesActivity::class.java))

        })


        addButton.setOnClickListener(View.OnClickListener {
            secondActivityWithResult2.launch(Intent(this,WeightActivity::class.java))

        })



        incButton.setOnClickListener(View.OnClickListener {
            glassesNumber++
            glassesText.text=glassesNumber.toString()


        })


        decButton.setOnClickListener(View.OnClickListener {
            if(glassesNumber==0)
            {
                glassesText.text="0"
            }
            else{
                glassesNumber--
                glassesText.text=glassesNumber.toString()
            }



        })


        editProfileInfo.setOnClickListener(View.OnClickListener {
            secondActivityWithResult3.launch(Intent(this,EditInfoActivity::class.java))

        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == picImagesNum) {
            imageUri = data?.data
            editProfilePic.setImageURI(imageUri)
        }
    }


}