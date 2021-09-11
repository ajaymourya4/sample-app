package com.ajaymourya.android.di.module

import com.ajaymourya.android.SampleApp
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class AppModuleTest {

    @MockK(relaxed = true)
    lateinit var application: SampleApp

    private lateinit var appModule: AppModule

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        appModule = AppModule()
    }

    @Test
    fun verifyProvidedContext() {
        assertThat(application.applicationContext).isEqualTo(appModule.provideContext(application))
    }
}
