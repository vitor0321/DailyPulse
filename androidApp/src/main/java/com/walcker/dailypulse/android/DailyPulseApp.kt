package com.walcker.dailypulse.android

import android.app.Application
import com.walcker.dailypulse.android.di.viewModelsModule
import com.walcker.dailypulse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

internal class DailyPulseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule
        startKoin {
            androidLogger()
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}