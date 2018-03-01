package com.balivo.heterogeneousrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var mItems: ArrayList<Any>
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize the items with 0 capacity
        mItems = ArrayList(0)
        myAdapter = MyAdapter(mItems)

        // create linear layout manager object
        val mLayoutManager = LinearLayoutManager(this)

        // default dividerItem decoration provided by RecyclerView
        val mDividerItemDecoration = DividerItemDecoration(
                recycler_view.context,
                mLayoutManager.orientation
        )
        recycler_view.layoutManager = mLayoutManager
        recycler_view.addItemDecoration(mDividerItemDecoration)
        recycler_view.adapter = myAdapter
        createDataSet()
    }
    // Dataset created with both the models alternatively
    private fun createDataSet() {
        mItems.add(TextType("Canada Nature"))
        mItems.add(ImageType(R.drawable.img_1))
        mItems.add(TextType("Girl"))
        mItems.add(ImageType(R.drawable.img_2))
        mItems.add(TextType("Canada Nature Second"))
        mItems.add(ImageType(R.drawable.img_3))
        mItems.add(TextType("Another Girl"))
        mItems.add(ImageType(R.drawable.img_4))
// notify the adapter that dataset has changed by
// calling notifyDataSetChanged method so the adapter
// can redraw the list
        myAdapter.notifyDataSetChanged()
    }
}