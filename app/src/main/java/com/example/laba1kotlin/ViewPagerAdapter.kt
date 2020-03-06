package com.example.laba1kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

class ViewPagerAdapter : PagerAdapter {

    var context : Context
    var myItems : ArrayList<MyAdapter.Technology>
    var firstPosition : Int = 0
    lateinit var layoutInflater: LayoutInflater

    constructor(context : Context, items : ArrayList<MyAdapter.Technology>) : super()
    {
        this.context = context
        this.myItems = items
        
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as LinearLayout

    override fun getCount(): Int {
        return myItems.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
    var image : ImageView
        var nameText : TextView
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view : View = layoutInflater.inflate(R.layout.slider_layout, container, false)
        image = view.findViewById(R.id.techIV)
        nameText = view.findViewById(R.id.techNameTV)
        var url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + myItems.get(position).graphic
        Picasso.with(context).load(url).into(image)
        nameText.setText(myItems.get(position).name)
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as LinearLayout)
    }
}