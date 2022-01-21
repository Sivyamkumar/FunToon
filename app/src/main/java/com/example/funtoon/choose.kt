package com.example.funtoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class choose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        val meme :TextView =findViewById(R.id.meme)
        val jokes : TextView =findViewById(R.id.joke)

        meme.setOnClickListener(){
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        jokes.setOnClickListener(){
            val intent=Intent(this,joke::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val alertdialog : AlertDialog = AlertDialog.Builder(this).create()
        alertdialog.setTitle("Exit")
        alertdialog.setMessage("Are you sure want to exit?")

        alertdialog.setButton(AlertDialog.BUTTON_POSITIVE,"yes"){
                dialog,which -> finishAffinity()
            dialog.dismiss()
        }

        alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                dialog,which ->
            dialog.dismiss()
        }
        alertdialog.show()
    }
}