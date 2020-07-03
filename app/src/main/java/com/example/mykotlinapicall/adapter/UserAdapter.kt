package com.example.mykotlinapicall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapicall.R
import com.example.mykotlinapicall.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList : MutableList<User> = ArrayList()

    fun setUser(users : MutableList<User>) {
        userList.addAll(users)
        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.userId.text = user.id.toString()
        holder.name.text = user.name
        holder.userName.text = user.username
        holder.email.text = user.email
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userId = itemView.findViewById<TextView>(R.id.userId)
        val name = itemView.findViewById<TextView>(R.id.name)
        val userName = itemView.findViewById<TextView>(R.id.userName)
        val email = itemView.findViewById<TextView>(R.id.email)
    }
}