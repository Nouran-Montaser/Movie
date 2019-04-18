package com.example.nouran.firstkotlinapp

import com.example.nouran.firstkotlinapp.MyModel.Results
import java.io.Serializable


object MyModel {

    data class MyPojo(var dates: Dates, var page: String, var total_pages: String, var results: Array<Results>, var total_results: String)

//    data class Results (var overview: String, var original_language: String, var original_title: String, var video: String, var title: String,
//                       var genre_ids: Array<String>, var poster_path: String, var backdrop_path: String, var release_date: String,
//                       var vote_average: String, var popularity: String, var id: String, var adult: String, var vote_count: String)

    data class Dates(var maximum: String, var minimum: String)

    data class MovieDetail(var original_language: String, var imdb_id: String, var video: String, var title: String, var backdrop_path: String,
          var revenue: String, var genres: Array<Genres>, var popularity: String, var production_countries: Array<Production_countries>,
          var id: String, var vote_count: Int, var budget: String, var overview: String, var original_title: String, var runtime: String,
          var poster_path: String, var spoken_languages: Array<Spoken_languages>, var production_companies: Array<Production_companies> ,
          var release_date: String, var vote_average: String, var belongs_to_collection: String, var tagline: String, var adult: String,
          var homepage: String, var status: String)

    data class Spoken_languages (var name: String , var iso_639_1: String)

    data class Production_countries (  var iso_3166_1: String,var name: String)

    data class Production_companies (var logo_path: String,var name: String,var id: String)
    data class Genres (var name: String,var id: String)


     class Results :Serializable {
        var overview: String? = null

        var original_language: String? = null

        var original_title: String? = null

        var video: String? = null

        var title: String? = null

        var genre_ids: Array<String>? = null

        var poster_path: String? = null

        var backdrop_path: String? = null

        var release_date: String? = null

        var vote_average: String? = null

        var popularity: String? = null

        var id: String? = null

        var adult: String? = null

        var vote_count: String? = null

        override fun toString(): String {
            return "ClassPojo [overview = $overview, original_language = $original_language, original_title = $original_title, video = $video, title = $title, genre_ids = $genre_ids, poster_path = $poster_path, backdrop_path = $backdrop_path, release_date = $release_date, vote_average = $vote_average, popularity = $popularity, id = $id, adult = $adult, vote_count = $vote_count]"
        }
    }


}
