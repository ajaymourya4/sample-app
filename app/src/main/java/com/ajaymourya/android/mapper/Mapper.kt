package com.ajaymourya.android.mapper

interface Mapper<F, T> {

    suspend fun map(from: F): T
}
