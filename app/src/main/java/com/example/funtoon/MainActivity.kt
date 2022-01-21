package com.example.funtoon

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadmeme()

        val next : TextView =findViewById(R.id.NextButton)

        next.setOnClickListener(){
            loadmeme()
        }

    }

    private fun loadmeme(): String{
        val progressBar : ProgressBar =findViewById(R.id.progressBar)
        progressBar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        var url = "https://meme-api.herokuapp.com/gimme/wholesomememes"
        var url3=" "
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                 url=response.getString("url")
                url3=url
                val sivi : ImageView = findViewById(R.id.sivi)
                Glide.with(this).load(url).listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        val toast= Toast.makeText(this@MainActivity,"Error !!!",Toast.LENGTH_LONG).show()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility=View.GONE
                        return false
                    }

                }).into(sivi);
            },
            { error ->

            }
        )
        queue.add(jsonObjectRequest)
        return url3;
    }



    override fun onBackPressed() {
        super.onBackPressed()
    }


}