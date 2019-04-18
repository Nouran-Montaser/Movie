package com.example.nouran.firstkotlinapp

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.io.Serializable

class MyAdapter(public val context : Context , private val myDataset: Array<MyModel.Results>) : RecyclerView.Adapter<MyAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false) as ViewGroup
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(myDataset.get(position))
    }

    override fun getItemCount() = myDataset.size

    class MovieViewHolder(view: ViewGroup) : RecyclerView.ViewHolder(view) {
        private var mTitleView: TextView? = null
        private var mPosterView: ImageView? = null
        private var mcontainer: LinearLayout? = null


        init {
            mTitleView = view.findViewById(R.id.SingleMovie_nametxt)
            mPosterView = view.findViewById(R.id.SingleMovie_img)
            mcontainer = view.findViewById(R.id.container)
        }

        fun bind(movie: MyModel.Results) {
            mTitleView?.text = movie.title
            if (movie.poster_path != "")
                Picasso.get().load("http://image.tmdb.org/t/p/w185/" + movie.poster_path).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(mPosterView)

            mcontainer?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(v?.context, DetailActivity::class.java)
                    intent.putExtra("key", movie as Serializable)
                    v?.context?.startActivity(intent)
                }
            })
//            {
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtra("key", "Kotlin")
//                startActivity(intent)
//            }
        }

    }
}