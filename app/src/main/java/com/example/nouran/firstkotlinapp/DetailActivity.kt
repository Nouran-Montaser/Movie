package com.example.nouran.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response


class DetailActivity : AppCompatActivity() {

    private lateinit var mBackImage: ImageView
    private lateinit var mOriginalTitle: TextView
    private lateinit var mUserRate : TextView
    private lateinit var mOverView: TextView
    private lateinit var mReleaseDate: TextView
    private lateinit var mFrontImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mBackImage = findViewById(R.id.BackImage)
        mOriginalTitle = findViewById(R.id.OriginalTitle)
        mUserRate = findViewById(R.id.UserRate)
        mOverView = findViewById(R.id.OverView)
        mReleaseDate = findViewById(R.id.ReleaseDate)
        mFrontImage = findViewById(R.id.FrontImage)

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        val result = intent.extras.get("key") as? MyModel.Results

        mOverView.text = result?.overview
        mOriginalTitle.text = result?.original_title
        mUserRate.text = result?.vote_average
        mReleaseDate.text = result?.release_date
        if (result?.poster_path != "")
            Picasso.get().load("http://image.tmdb.org/t/p/w185/" + result?.poster_path).placeholder(R.drawable.placeholder).
                    error(R.drawable.placeholder).into(mFrontImage)

        if (result?.backdrop_path != "")
            Picasso.get().load("http://image.tmdb.org/t/p/w185/" + result?.backdrop_path).placeholder(R.drawable.placeholder).
                    error(R.drawable.placeholder).into(mBackImage)

    }
}
