package com.example.nonnavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(val ListKalimat : ArrayList<DataList>) : RecyclerView.Adapter<AlphabetAdapter.LetterViewHolder>(){
    var onClick: ((DataList) -> Unit)? = null

    class LetterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val button = itemView.findViewById<Button>(R.id.switch_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_layout,parent,false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = ListKalimat[position].key
        holder.button.text = item
        holder.button.setOnClickListener {
            onClick?.invoke(ListKalimat[position])
        }
    }

    override fun getItemCount(): Int {
        return ListKalimat.size
    }

}