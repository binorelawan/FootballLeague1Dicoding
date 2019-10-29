package relawan.footballleague1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import relawan.footballleague1.models.League

class LeagueAdapter(private var items: List<League>, private val listener: (League) -> Unit) : RecyclerView.Adapter<LeagueAdapter.MyViewHolder>(){


    fun submitList(leagueList: List<League>){
        items = leagueList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position], listener)

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.league_name)
        private val logo = itemView.findViewById<ImageView>(R.id.logo)


        fun bind(league: League, listener: (League) -> Unit) {
            name.text = league.name
            league.logo.let { Picasso.get().load(league.logo).fit().into(logo) }

            itemView.setOnClickListener {
                listener(league)
            }

        }

        companion object {
            fun from (parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_list, parent, false)

                return MyViewHolder(view)
            }
        }
    }
}