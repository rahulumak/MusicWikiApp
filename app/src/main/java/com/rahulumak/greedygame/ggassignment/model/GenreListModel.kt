package com.rahulumak.greedygame.ggassignment.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreListModel(
    @SerializedName("toptags")
    val toptags: Toptags
) :Parcelable{
    @Parcelize
    data class Toptags(
        @SerializedName("@attr")
        val attr: Attr,
        @SerializedName("tag")
        val tag: List<Tag>
    ):Parcelable {
        @Parcelize
        data class Attr(
            @SerializedName("num_res")
            val numRes: Int,
            @SerializedName("offset")
            val offset: Int,
            @SerializedName("total")
            val total: Int
        ):Parcelable

        @Parcelize
        @Entity
        data class Tag(
            @PrimaryKey(autoGenerate = true) val id: Int = 0,
            @SerializedName("count")
            @ColumnInfo(name = "count")
            val count: Int,
            @SerializedName("name")
            @ColumnInfo(name = "name")
            val name: String,
            @SerializedName("reach")
            @ColumnInfo(name = "reach")
            val reach: Int
        ):Parcelable {
            constructor(count: Int, name: String, reach: Int) : this(0, count, name, reach)
        }
    }
}