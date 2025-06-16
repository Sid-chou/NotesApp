package com.example.notionclone

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NotionRepository(application)
    val pages: LiveData<List<Page>> = repository.getActivePages()
}