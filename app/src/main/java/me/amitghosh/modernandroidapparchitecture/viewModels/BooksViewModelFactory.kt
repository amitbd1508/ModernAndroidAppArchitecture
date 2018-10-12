package me.amitghosh.modernandroidapparchitecture.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.amitghosh.modernandroidapparchitecture.data.BookRepository

class BooksViewModelFactory(
        private val repository: BookRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = BooksViewModelFactory(repository) as T
}