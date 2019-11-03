package relawan.footballleague1

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import relawan.footballleague1.models.League

class DetailActivity : AppCompatActivity() {

    private var name:String? = ""
    private var logo:Int = 0
    private var desc: String? = ""

    private lateinit var nameTextView: TextView
    private lateinit var logoImageView: ImageView
    private lateinit var descTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<League>(MainActivity.LEAGUE_DATA)

        scrollView {
            background = ColorDrawable(ContextCompat.getColor(context, R.color.cardViewBackGround))

            verticalLayout {
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                logoImageView = imageView{

                }.lparams(width = 512, height = 512)

                nameTextView = textView {
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = Color.BLACK
                    textSize = 24F
                }.lparams {
                    topMargin = dip(8) }

                descTextView = textView{
                    textSize = 16F
                }.lparams {
                    topMargin = dip(16) }
            }
        }

        name = item?.name
        logo = item!!.logo
        desc = item.desc

        nameTextView.text = item.name
        logoImageView.setImageResource(item.logo)
        descTextView.text = item.desc


        actionBarTitle()
    }

    private fun actionBarTitle() {
        val actionBar = supportActionBar
        actionBar?.title = name
    }
}
