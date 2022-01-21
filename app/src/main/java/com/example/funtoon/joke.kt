package com.example.funtoon

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils
import androidx.core.content.res.TypedArrayUtils.getText
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlin.text.StringBuilder as StringBuilder
import android.view.ContextMenu.ContextMenuInfo

import android.view.ContextMenu





class joke : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        loadalljokes()

        var number =0

        val copyjoke : TextView =findViewById(R.id.copyjoke)
        val nextjoke : TextView =findViewById(R.id.nextjoke)

        val all : TextView = findViewById(R.id.all)
        val miss : TextView = findViewById(R.id.miss)
        val programming : TextView = findViewById(R.id.programming)
        val dark : TextView = findViewById(R.id.dark)
        val pun : TextView = findViewById(R.id.pun)
        val spooky : TextView = findViewById(R.id.spooky)
        val christmas : TextView = findViewById(R.id.christmas)

        all.setOnClickListener(){
            number=1
            all.setTextColor(Color.rgb(255,255,255))
            miss.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loadalljokes()
        }
        miss.setOnClickListener(){
            number=2
            miss.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loadmissjokes()
        }
        programming.setOnClickListener(){
            number=3
            programming.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            miss.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loadprogrammingjokes()
        }
        dark.setOnClickListener(){
            number=4
            dark.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            miss.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loaddarkjokes()
        }
        pun.setOnClickListener(){
            number=5
            pun.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            miss.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loadpunjokes()
        }
        spooky.setOnClickListener(){
            number=6
            spooky.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            miss.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            christmas.setTextColor(Color.rgb(3,169,244))
            loadspookyjokes()
        }
        christmas.setOnClickListener(){
            number=7
            christmas.setTextColor(Color.rgb(255,255,255))
            all.setTextColor(Color.rgb(3,169,244))
            miss.setTextColor(Color.rgb(3,169,244))
            programming.setTextColor(Color.rgb(3,169,244))
            dark.setTextColor(Color.rgb(3,169,244))
            pun.setTextColor(Color.rgb(3,169,244))
            spooky.setTextColor(Color.rgb(3,169,244))
            loadchristmasjokes()
        }

        copyjoke.setOnClickListener() {
            copyTextToClipboard()
            Toast.makeText(this, "Text Copied Successfully.", Toast.LENGTH_LONG).show()
        }

        nextjoke.setOnClickListener(){
            whichjoke(number)
        }
    }

    private fun loadalljokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/Any"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
            response ->
            val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                val setup :TextView = findViewById(R.id.setup)

                progressbar.visibility= View.GONE

                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
        },{
            error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loadprogrammingjokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/Programming"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("joke")
                var sivi=" "

                val setup :TextView = findViewById(R.id.setup)

                progressbar.visibility= View.GONE

                setup.setText(sam)
                setup.append("\n")
                setup.append(sivi.toString())

            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loadmissjokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/Miscellaneous"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                val setup :TextView = findViewById(R.id.setup)

                progressbar.visibility= View.GONE

                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loaddarkjokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/Dark"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                val setup :TextView = findViewById(R.id.setup)

                progressbar.visibility= View.GONE

                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loadpunjokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/pun"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                progressbar.visibility= View.GONE

                val setup :TextView = findViewById(R.id.setup)

                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loadspookyjokes(){


        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/spooky"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                progressbar.visibility= View.GONE

                val setup :TextView = findViewById(R.id.setup)


                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun loadchristmasjokes(){

        val progressbar : ProgressBar = findViewById(R.id.progressbar)
        progressbar.visibility= View.VISIBLE

        val queue = Volley.newRequestQueue(this)
        val url = "https://v2.jokeapi.dev/joke/christmas"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,{
                    response ->
                val sam= response.getString("setup")
                val sivi =response.getString("delivery")

                val setup :TextView = findViewById(R.id.setup)

                progressbar.visibility= View.GONE

                setup.setText(sam)
                setup.append("\n")
                setup.append("\n")
                setup.append(sivi.toString())
            },{
                    error ->

                Toast.makeText(this, "Unable to load jokes.", Toast.LENGTH_SHORT).show()

            })
        queue.add(jsonObjectRequest)
    }

    private fun whichjoke(number :Int){
        if(number == 0){
            return loadalljokes()
        }
        if(number == 1){
            return loadalljokes()
        }
        if(number == 2){
            return loadmissjokes()
        }
        if(number == 3){
            return loadprogrammingjokes()
        }
        if(number == 4){
            return loaddarkjokes()
        }
        if(number == 5){
            return loadpunjokes()
        }
        if(number == 6){
            return loadspookyjokes()
        }
        if(number == 7){
            return loadchristmasjokes()
        }

    }

    private fun copyTextToClipboard() {
        val setup :TextView = findViewById(R.id.setup)

        val myClipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val myClip: ClipData = ClipData.newPlainText("text", setup.text)

        myClipboard.setPrimaryClip(myClip)

    }

}






