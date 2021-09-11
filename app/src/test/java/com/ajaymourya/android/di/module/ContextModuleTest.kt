package com.ajaymourya.android.di.module

import com.ajaymourya.android.SampleApp
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ContextModuleTest {

    @MockK(relaxed = true)
    lateinit var application: SampleApp

    private lateinit var contextModule: ContextModule

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        contextModule = ContextModule(application)
    }

    @Test
    fun verifyProvideContext() {
        assertThat(application).isEqualTo(contextModule.provideContext())
    }
}
