package com.example.mvvmtestproject.utilities

import com.example.mvvmtestproject.data.FakeDatabase
import com.example.mvvmtestproject.data.QuoteRepository
import com.example.mvvmtestproject.ui.quotes.QuotesViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object InjectorUtils {

    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}