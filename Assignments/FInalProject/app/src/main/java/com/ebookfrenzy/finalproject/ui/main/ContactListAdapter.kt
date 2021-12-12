package com.ebookfrenzy.finalproject.ui.main

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.ebookfrenzy.finalproject.Contact
import com.ebookfrenzy.finalproject.R

class ContactListAdapter(private val contactLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    var listener: OnGarbageClicked? = null

    interface OnGarbageClicked {
        fun onGarbageClicked(id: String)
   }

    fun settingListener(listener: OnGarbageClicked?) {
        this.listener = listener
    }





    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardName: TextView = itemView.findViewById(R.id.contName)
        var cardNumber: TextView = itemView.findViewById(R.id.contNumber)
        var cardId: TextView = itemView.findViewById(R.id.id)
        var trashCan: ImageButton = itemView.findViewById(R.id.deleteKey)

    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {

        val cardName = holder.cardName
        val cardNumber = holder.cardNumber
        val cardId = holder.cardId

        contactList.let {
            cardName.text = it!![listPosition].contactName
            cardNumber.text = it!![listPosition].contactNumber // THIS ADD THE NUMBER TO THE CONTACT NAME HOW TO LIST
            cardId.text = it!![listPosition].id.toString()
        }

        holder.trashCan.setOnClickListener(View.OnClickListener {

            var textId = cardId.text.toString()

           listener?.onGarbageClicked(textId)

        })


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