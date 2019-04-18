package com.example.nouran.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var COLUMN_NUM = 2;
    //    val numbers: IntArray = intArrayOf
    private val mNicolasCageMovies = arrayOf(
            Movie(1, "Raising Arizona", ""),
            Movie(2, "Vampire's Kiss", ""),
            Movie(3, "Con Air", ""),
            Movie(4, "Gone in 60 Seconds", ""),
            Movie(5, "National Treasure", ""),
            Movie(6, "The Wicker Man", ""),
            Movie(8, "Knowing", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        viewManager = GridLayoutManager(this, COLUMN_NUM)
        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, COLUMN_NUM)
        getData()
    }

    private fun getData() {

        Client.makeService().create(Client::class.java).getMovieData("now_playing", "214cc6f08673d0af40d2a203b2c32143", 1)
                .enqueue(object : retrofit2.Callback<MyModel.MyPojo> {
                    override fun onResponse(call: Call<MyModel.MyPojo>, response: Response<MyModel.MyPojo>) {
                        if (response.body() != null) {
                            val respo = response.body()
                            recyclerView.adapter = MyAdapter(this@MainActivity,respo?.results!!)
                        }
                    }

                    override fun onFailure(call: Call<MyModel.MyPojo>?, t: Throwable?) {
                        Log.i("PLPLPL", t.toString())
                    }
                })
    }
}

