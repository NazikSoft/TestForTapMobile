package com.naziksoft.testfortapmobile.di

import com.naziksoft.testfortapmobile.viewmodel.PlayerViewModel
import com.naziksoft.testfortapmobile.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SearchViewModel() }
    viewModel { PlayerViewModel() }
}