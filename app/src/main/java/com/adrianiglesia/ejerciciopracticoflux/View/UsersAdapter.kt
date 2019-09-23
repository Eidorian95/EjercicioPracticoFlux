package com.adrianiglesia.ejerciciopracticoflux.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianiglesia.ejerciciopracticoflux.Model.User
import com.adrianiglesia.ejerciciopracticoflux.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_users.view.*

class UsersAdapter(val users:List<User>, private val itemClickListener:OnItemClickListener): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_users, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(users[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User, itemClickListener: OnItemClickListener) {
            itemView.card_username.text = user.login.username
            itemView.card_country.text=user.nat
            val picasso = Picasso.get()
            picasso.load(user.picture.large)
                .resize(70,70)
                .into(itemView.card_image)

            itemView.setOnClickListener { itemClickListener.onItemClicked(user) }
        }
    }



    interface OnItemClickListener{
        fun onItemClicked(user: User)
    }
}