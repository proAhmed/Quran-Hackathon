package com.hackathon.quran

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.quran.databinding.ActivityMainBinding
import pl.aprilapps.easyphotopicker.EasyImage
import java.io.File


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnImage.setOnClickListener {
            startActivity(Intent(this,CameraActivity::class.java))
        }
        binding.btnService.setOnClickListener {
            startActivity(Intent(this,OtherService::class.java))
        }
    }
    private fun dispatchTakePictureIntent() {
        EasyImage.openCameraForImage(this, 100)
    }

    private fun onImagePicked(requestCode: Int, resultCode: Int, data: Intent?) {
        EasyImage.handleActivityResult(
            requestCode,
            resultCode,
            data,
            this,
            object : EasyImage.Callbacks {
                override fun onImagePickerError(
                    e: Exception,
                    source: EasyImage.ImageSource,
                    type: Int
                ) {
                }

                override fun onImagesPicked(
                    imageFiles: List<File>,
                    source: EasyImage.ImageSource,
                    type: Int
                ) {

                }

                override fun onCanceled(source: EasyImage.ImageSource, type: Int) {


                }
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        onImagePicked(requestCode, resultCode, data)
    }

}