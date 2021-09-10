package com.ajaymourya.android.ui.list.di

import com.ajaymourya.android.di.component.CoreComponent
import com.ajaymourya.android.di.scopes.FeatureScope
import com.ajaymourya.android.ui.list.MovieListFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [MovieListModule::class],
    dependencies = [CoreComponent::class]
)
interface MovieListComponent {

    fun inject(fragment: MovieListFragment)
}
