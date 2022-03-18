package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.CardViewHeroHolder>() {
    class CardViewHeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        private val tvItemDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
        private val imgItemPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        private val btnSetFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        private val btnSetShare: Button = itemView.findViewById(R.id.btn_set_share)

        fun bind(hero: Hero) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgItemPhoto)

                tvItemName.text = hero.name
                tvItemDesc.text = hero.desc

                btnSetFavorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${hero.name}", Toast.LENGTH_SHORT).show() }

                btnSetShare.setOnClickListener { Toast.makeText(itemView.context, "Share ${hero.name}", Toast.LENGTH_SHORT).show() }

                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): CardViewHeroHolder {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.item_cardview_hero, viewgroup, false)
        return CardViewHeroHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHeroHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size
}