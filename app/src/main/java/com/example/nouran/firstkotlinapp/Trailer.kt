package com.example.nouran.firstkotlinapp

object Trailer {
    data class Trailers (var id: String,var results: Array<MyModel.Results>)

    data class Results(var site: String, var size: String, var iso_3166_1: String, var name: String, var id: String, var type: String, var iso_639_1: String, var key: String)
}