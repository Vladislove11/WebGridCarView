package com.example.webgridcarview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var gridViewGV : GridView
    private var list = mutableListOf(
        GridViewModal("mail.ru", R.drawable.mail,"https://mail.ru/"),
        GridViewModal("rambler.ru", R.drawable.rambler,"https://www.rambler.ru/"),
        GridViewModal("afisha.ru", R.drawable.afisha,"https://www.afisha.ru/"),
        GridViewModal("pinterest.com", R.drawable.pinterest,"https://ru.pinterest.com/"),
        GridViewModal("github.com", R.drawable.github,"https://github.com/"),
        GridViewModal("oper.ru", R.drawable.oper,"https://oper.ru/")
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        gridViewGV = findViewById(R.id.gridViewGV)

        val adapter = GridViewAdapter(list = list, this@MainActivity)
        gridViewGV.adapter = adapter

        gridViewGV.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(list[position].address)))
        }

    }
}