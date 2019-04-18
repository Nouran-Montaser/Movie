package com.example.nouran.firstkotlinapp

import android.database.Observable
import android.graphics.ColorSpace
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface Client {

    @GET("movie/{type}")
    fun getMovieData(@Path("type") sortType: String, @Query("api_key") apiKey: String, @Query("page") pageNum: Int):Call<MyModel.MyPojo>


    @GET("movie/{id}/videos")
    fun getTrailersforMovie(@Path("id") MovieID: String, @Query("api_key") apiKey: String): Call<Trailer.Trailers>

    @GET("movie/{id}/reviews")
    fun getReviewsforMovie(@Path("id") MovieID: String, @Query("api_key") apiKey: String): Call<Review.Reviews>

    //Kotlin companion object is used to make the create function below resembler the static method of Java Factory pattern.
    companion object {
       fun makeService(): Retrofit {
           return Retrofit.Builder()
                   .addCallAdapterFactory(
                           RxJava2CallAdapterFactory.create())
                   .addConverterFactory(
                           GsonConverterFactory.create())
                   .baseUrl("https://api.themoviedb.org/3/")
                   .build()
       }


    }
}