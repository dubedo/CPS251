package com.ebookfrenzy.recycleviewintentmp08

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var vm = MainViewModel
    var theData = Data.instanceOfData()

    override fun getItemCount(): Int {
        return 8;
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = theData.dataTitles[vm.detailValues[i][0]]
        viewHolder.itemDetail.text = theData.dataDetails[vm.detailValues[i][1]]
        viewHolder.itemImage.setImageResource(theData.dataImages[vm.detailValues[i][2]])

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->

                var positionInArray: Int = adapterPosition

                var theTitles = vm.detailValues[positionInArray][0]
                var theDetails = vm.detailValues[positionInArray][1]
                var theImages = vm.detailValues[positionInArray][2]

                val i = Intent(v.getContext(), MainActivity2::class.java)

                i.putExtra("detail", theDetails)
                i.putExtra("title", theTitles)
                i.putExtra("image", theImages)

                startActivity(v.context, i, null)

            }

        }
    }




}