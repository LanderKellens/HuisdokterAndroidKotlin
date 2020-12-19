package com.example.huisdoktersgent.data.remote

import com.example.huisdoktersgent.BuildConfig
import com.example.huisdoktersgent.models.DokterData
import com.example.huisdoktersgent.utils.Resource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.*

private const val BASE_URL = "https://data.stad.gent/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val interceptor = HttpLoggingInterceptor()
    .setLevel(if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface GhentApiService {
    @GET("api/records/1.0/search/?dataset=locaties-huisartsen-gent&q=&facet=gemeente&facet=postcode")
    suspend fun getDokters(): Response<DokterData>
}

object GhentApi {
    val apiService: GhentApiService by lazy { retrofit.create(GhentApiService::class.java) }
}