package com.ebookfrenzy.finalproject.ui.main

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.ebookfrenzy.finalproject.Contact
import com.ebookfrenzy.finalproject.R

class ContactListAdapter(private val contactLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

//    interface OnGarbageClicked {
//        fun onGarbageClicked(position: Int, v: View)
//    }

    private var contactList: List<Contact>? = null
   // private var garbageListener: OnGarbageClicked = null



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.contName)
        var number: TextView = itemView.findViewById(R.id.contNumber)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {

        val item = holder.item
        val number = holder.number

        contactList.let {
            item.text = it!![listPosition].contactName
            number.text = it!![listPosition].contactNumber // THIS ADD THE NUMBER TO THE CONTACT NAME HOW TO LIST
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(contactLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

}