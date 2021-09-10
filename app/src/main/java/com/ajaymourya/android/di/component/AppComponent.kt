package com.ajaymourya.android.di.component

import com.ajaymourya.android.SampleApp
import com.ajaymourya.android.di.module.AppModule
import com.ajaymourya.android.di.scopes.AppScope
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: SampleApp)
}
