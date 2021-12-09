package com.example.final_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val personItemLayout: Int) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var ContactList: List<Person>? = null

    var listener: onItemCickListener? = null

    fun settingListener(listener: onItemCickListener){
        this.listener = listener
    }

    interface onItemCickListener{
        fun onClick(string: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(personItemLayout, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ContactList.let {
            holder.itemName.text = it!![position].personName
            holder.itemPhone.text = it!![position].personNumber
            holder.itemId.text = it!![position].id.toString()
        }

        holder.delete.setOnClickListener(View.OnClickListener {
            var id = holder.itemId.text.toString()
            listener?.onClick(id)
        })
    }

    fun setContactList(contacts: List<Person>){
        ContactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if(ContactList == null) 0 else ContactList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemName: TextView
        var itemPhone: TextView
        var delete: ImageView
        var itemId: TextView

        init {
            itemId = itemView.findViewById(R.id.ContactId)
            itemName = itemView.findViewById(R.id.name)
            itemPhone = itemView.findViewById(R.id.number)
            delete = itemView.findViewById(R.id.delete)
        }
    }
}