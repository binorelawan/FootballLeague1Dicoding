package relawan.footballleague1

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import relawan.footballleague1.models.League

class LeagueAdapter(private var items: List<League>, private val listener: (League) -> Unit) : RecyclerView.Adapter<LeagueAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LeagueUI().createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position], listener)

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(LeagueUI.name)
        private val logo = itemView.findViewById<ImageView>(LeagueUI.logo)


        fun bind(league: League, listener: (League) -> Unit) {
            name.text = league.name
            league.logo.let { Picasso.get().load(league.logo).fit().into(logo) }

            itemView.setOnClickListener {
                listener(league)
            }

        }


    }
}