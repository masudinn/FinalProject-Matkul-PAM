package com.masudinn.fp_pam_2087.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent
import com.masudinn.fp_pam_2087.R
import com.masudinn.fp_pam_2087.UI.DetailMain.DetailActivity
import kotlinx.android.synthetic.main.item_last_match.view.*
import org.jetbrains.anko.startActivity

class TeamAdapter(private val eventList:List<MatchEvent>, val context: Context?): RecyclerView.Adapter<TeamAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.item_last_match, parent, false))
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: MatchEvent){
            if(event.intHomeScore == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (context != null) {
                        itemView.dateScheduleTv.setTextColor(context.getColor(R.color.purple_200))
                    }
                }
            }
            itemView.dateScheduleTv.text = event.dateEvent
            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore


            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("match" to event)
            }
        }
    }

}