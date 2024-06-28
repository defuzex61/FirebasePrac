package com.example.firebaseprac.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseprac.R

import com.example.firebaseprac.user.NoteFirebase
import com.example.firebaseprac.user.NoteManager

class RecyclerViewAdapter(private val itemList: List<String>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    lateinit var mainViewModel: MainViewModel
    lateinit var noteFirebase: NoteFirebase
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//С лайфдата над чет делать
        val item = itemList[position]//Я только открыл это мне уже плохо...
/*
        holder.itemView.setOnClickListener() { v->
            val intent = Intent(v.getContext(), ::class.java)
            intent.putExtra("userId", noteFirebase.userId)
            intent.putExtra("note", noteFirebase.note)
            v.getContext().startActivities(arrayOf<Intent>(intent))
        }
*/
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewHolder(itemView: View) {

        }
    }
}