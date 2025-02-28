package com.example.janintriassignment.di.modules

import com.example.janintriassignment.ui.screens.home_screen.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        HomeViewModel(get())
    }
}