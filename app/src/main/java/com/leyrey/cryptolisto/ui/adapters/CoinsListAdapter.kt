package com.leyrey.cryptolisto.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leyrey.cryptolisto.R
import com.leyrey.cryptolisto.data.remote.coinMarketCapModel.CoinMarketCapCoin

class CoinsListAdapter(val list: ArrayList<CoinMarketCapCoin>) : RecyclerView.Adapter<CoinsListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder?.tvCoinName?.text = item.name
        holder?.tvCoinRank?.text = item.rank.toString()
        holder?.tvCoinPrice?.text = item.quotes.currency.price.toString()
        holder?.tvCoinMarketCap?.text = item.quotes.currency.market_cap.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_coin, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }


    class ViewHolder(view: View)  : RecyclerView.ViewHolder(view) {
        var tvCoinName : TextView
        var tvCoinRank: TextView
        var tvCoinPrice: TextView
        var tvCoinMarketCap: TextView

        init {
            tvCoinName = view.findViewById(R.id.tv_coin_name)
            tvCoinRank = view.findViewById(R.id.tv_coin_rank)
            tvCoinPrice = view.findViewById(R.id.tv_coin_price)
            tvCoinMarketCap = view.findViewById(R.id.tv_coin_market_cap)
        }
    }
}