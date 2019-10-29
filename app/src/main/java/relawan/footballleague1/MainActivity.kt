package relawan.footballleague1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import relawan.footballleague1.models.League

class MainActivity : AppCompatActivity() {

    lateinit var adapter: LeagueAdapter
    private var items: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createData()
        adapter.submitList(data)
    }


    private fun initRecyclerView() {
        val manager = GridLayoutManager(this,2)
        recyclerview.layoutManager = manager

        adapter = LeagueAdapter(items) {
            startActivity<DetailActivity>("name" to it.name, "logo" to it.logo, "desc" to it.desc)
        }

        recyclerview.adapter = adapter
    }


}
