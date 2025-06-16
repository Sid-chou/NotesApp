package com.example.notionclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notionclone.R

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Search"
    }
}