package mobi.asta.task2.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class Repository(val id: Int,
                      val title: String,
                      val description: String?,
                      val numberOfStars: Int,
                      val numberOfForks: Int,
                      val numberOfWatchers: Int,
                      val numberOfIssues: Int,
                      val language: String?,
                      val updateDate: Date?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            Date(parcel.readLong())) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(numberOfStars)
        parcel.writeInt(numberOfForks)
        parcel.writeInt(numberOfWatchers)
        parcel.writeInt(numberOfIssues)
        parcel.writeString(language)
        parcel.writeLong(updateDate?.time ?: 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Repository> {
        override fun createFromParcel(parcel: Parcel): Repository {
            return Repository(parcel)
        }

        override fun newArray(size: Int): Array<Repository?> {
            return arrayOfNulls(size)
        }
    }

}