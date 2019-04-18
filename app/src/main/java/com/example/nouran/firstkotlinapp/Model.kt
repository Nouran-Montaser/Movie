package com.example.nouran.firstkotlinapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

data class Movie( val id: Int, val name: String ,val posterPath: String)

//import javax.persistence.*
//
//@Entity
//data class Movie(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//                 val Id: Long,
//                 val name: String)
//class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)
//{
//    var x = 0;
//}

