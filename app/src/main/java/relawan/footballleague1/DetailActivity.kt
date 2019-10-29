package relawan.footballleague1

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var name:String? = ""
    private var logo:Int = 0
    private var desc: String? = ""

    lateinit var nameTextView: TextView
    lateinit var logoImageView: ImageView
    lateinit var descTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        scrollView {

            verticalLayout {
                padding = dip(16)
                gravity = Gravity.CENTER_HORIZONTAL

                logoImageView = imageView{}.lparams(width = 512, height = 512)

                nameTextView = textView {
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = Color.BLACK
                    textSize = 24F
                }.lparams { topMargin = dip(8) }

                descTextView = textView{
                    textSize = 16F
                }.lparams { topMargin = dip(16) }
            }
        }

        val intent = intent
        name = intent.getStringExtra("name")
        logo = intent.getIntExtra("logo",0)
        desc = intent.getStringExtra("desc")
        nameTextView.text = name
        logoImageView.setImageResource(logo)
        descTextView.text = desc


        //to change title of activity
        actionBarTitle()
    }

    private fun actionBarTitle() {
        val actionBar = supportActionBar
        actionBar?.title = name
    }
}
