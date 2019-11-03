package relawan.footballleague1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import relawan.footballleague1.models.League

class MainActivity : AppCompatActivity() {

    companion object {
        const val LEAGUE_DATA = "League"
    }

    private lateinit var adapter: LeagueAdapter
    private var items: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityUI(items).setContentView(this)
        initData()

    }

    class MainActivityUI(private val items: List<League>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, wrapContent)

                recyclerView {
                    layoutManager = GridLayoutManager(context,2)
                    adapter = LeagueAdapter(items) {
                        startActivity<DetailActivity>(LEAGUE_DATA to it)
                    }
                }
            }
        }
    }



    private fun initData() {
        val logo = resources.obtainTypedArray(R.array.league_logo)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_desc)

        items.clear()

        for (i in name.indices) {
            items.add(League(logo = logo.getResourceId(i, 0), name = name[i], desc = desc[i]))
        }

        logo.recycle()
    }
}
