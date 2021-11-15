package com.ebookfrenzy.recycler_cardviewmp07

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // create an instance of ViewModel

    var vm = MainViewModel


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Click Detected on Item $position", Snackbar.LENGTH_LONG).setAction("Action", null)
                    .show()
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = vm.getTitles()[i]
        viewHolder.itemDetail.text = vm.getDetails()[i]
        viewHolder.itemImage.setImageResource(vm.getImages()[i])
        // set equal to viewmodel . getter for array[i]

        // viewHolder.itemTitle.text = titles[i]
        // viewHolder.itemDetail.text = details[i]
        // viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        // viewmodel .getsize

        return 8;
    }

}