package relawan.footballleague1.models


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League (val name: String, val logo: Int, val desc: String) : Parcelable