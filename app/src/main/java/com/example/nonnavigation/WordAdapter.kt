package com.example.nonnavigation

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(val words: ArrayList<ListKalimat>) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    var onClick: ((ListKalimat) -> Unit)? = null

    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var button = itemView.findViewById<Button>(R.id.switch_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_layout,parent,false)
        return WordAdapter.WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val kata = words[position].kalimat
        holder.button.text = kata
        holder.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$kata"))
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return words.size
    }
}