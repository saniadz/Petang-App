package com.capstone.petang.data.remote.retrofit

import androidx.viewbinding.BuildConfig
import com.capstone.petang.BuildConfig.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {

        var API_BASE_URL_MOCK: String? = null

        /**
         * API service provider
         *
         * @return ApiService
         */
        fun getApiService(): ApiService {
            val loggingInterceptor = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }

//            val client = OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .build()

            val client = OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES) // write timeout
                .readTimeout(2, TimeUnit.MINUTES) // read timeout
//                .addInterceptor(
//                    BasicAuthInterceptor(
//                        AmvaccAppConstants.AUTHENTICATE_USER_NAME, AmvaccAppConstants.AUTHENTICATE_USER_PASSWORD
//                    )
//                )
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL_MOCK ?: API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}