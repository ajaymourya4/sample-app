package com.ajaymourya.android

import android.app.Application
import android.content.Context
import com.ajaymourya.android.di.component.CoreComponent
import com.ajaymourya.android.di.component.DaggerAppComponent
import com.ajaymourya.android.di.component.DaggerCoreComponent
import com.ajaymourya.android.di.module.ContextModule

class SampleApp : Application() {

    lateinit var coreComponent: CoreComponent

    companion object {
        fun coreComponent(context: Context) =
            (context.applicationContext as? SampleApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }
}
