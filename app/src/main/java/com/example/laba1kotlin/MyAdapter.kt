package com.example.laba1kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layour_elements.view.*
import java.net.URL
import android.graphics.drawable.Drawable
import com.squareup.picasso.Picasso
import java.io.InputStream


class MyAdapter(val items : ArrayList<Technology>, val context: Context, var clickListener: MyClickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layour_elements,
                parent,
                false
            )
        )

    }

    // Прогрузка элементов в адаптере
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = items.get(position).name
        var url =
            "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + items.get(
                position
            ).graphic
        Picasso.with(context).load(url).into(holder?.image)

        holder.initialize(items.get(position), clickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.item_textView
        var helpText = ""
        var image = view.item_icon

        fun initialize(item: Technology, action: MyClickListener) {
            name.text = item.name
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    class Technology(val name: String, val graphic: String)

    interface MyClickListener {
        fun onItemClick(item: Technology, position: Int)
    }

}