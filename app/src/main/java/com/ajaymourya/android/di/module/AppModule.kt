package com.ajaymourya.android.di.module

import android.content.Context
import com.ajaymourya.android.SampleApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: SampleApp): Context = application.applicationContext
}
