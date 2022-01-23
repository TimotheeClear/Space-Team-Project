package com.example.spacedim

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacedim.network.User
import android.widget.TextView

class UserAdapter(val displayedUsers : Array<User>, val listener: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val ma_ligne = LayoutInflater.from(parent.context).inflate(R.layout.fragment_name, parent, false)
        return ViewHolder(ma_ligne)
    }

    override fun getItemCount(): Int = displayedUsers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(displayedUsers[position],listener)
    }

    class ViewHolder(val elementDeListe : View) : RecyclerView.ViewHolder(elementDeListe)
    {
        fun bind(user: User, listener: (User) -> Unit) = with(itemView)
        {
            findViewById<TextView>(R.id.mainName).text = user.name
            findViewById<TextView>(R.id.state).text = user.state.toString()
            setOnClickListener { listener(user) }
        }
    }
}