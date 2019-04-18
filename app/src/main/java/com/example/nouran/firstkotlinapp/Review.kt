package com.example.nouran.firstkotlinapp

object Review {
    data class Reviews(var id: String, var page: String, var total_pages: String, var results: Array<Results>, var total_results: String)

    data class Results(var author: String, var id: String, var content: String, var url: String)

}