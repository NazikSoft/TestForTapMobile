package com.naziksoft.testfortapmobile

import android.app.Application
import com.naziksoft.testfortapmobile.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class YoutubeParserApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin {
            androidContext(this@YoutubeParserApplication)
            androidLogger(Level.ERROR)
            modules(appModule)
        }
    }
}