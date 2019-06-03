package com.tgeanezini.mobile.roomwordsample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tgeanezini.mobile.roomwordsample.R
import com.tgeanezini.mobile.roomwordsample.db.entity.Contact

class ContactListAdapter internal constructor(context: Context) : RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var contacts = emptyList<Contact>()

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstNameView = itemView.findViewById<TextView>(R.id.label_first_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = inflater.inflate(R.layout.contact_list_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = contacts[position]
        holder.firstNameView.text = current.firstName
    }

    internal fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }
}