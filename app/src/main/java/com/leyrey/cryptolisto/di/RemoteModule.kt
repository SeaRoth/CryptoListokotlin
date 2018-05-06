package com.leyrey.cryptolisto.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.leyrey.cryptolisto.data.remote.RemoteCoinMarketCapService
import com.leyrey.cryptolisto.data.remote.RemoteConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
            GsonBuilder()
                    .setLenient()
                    .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()


    @Provides
    @Singleton
    @Named("COINMARKETCAP_API")
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(RemoteConfig.CMC_BASE_API_LAYER)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()


    @Provides
    @Singleton
    fun provideRemoteWeatherService(@Named("COINMARKETCAP_API") retrofit: Retrofit): RemoteCoinMarketCapService =
            retrofit.create(RemoteCoinMarketCapService::class.java)



}