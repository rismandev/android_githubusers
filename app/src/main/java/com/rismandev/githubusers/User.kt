package com.rismandev.githubusers

import android.os.Parcel
import android.os.Parcelable

/*
 * Created by Risman Abdilah on 22/06/20 23.26.
 * Copyright (c) 2020. All right reserved.
 */
 
data class User(
    var name: String?,
    var username: String?,
    var avatar: Int?,
    var company: String?,
    var location: String?,
    var repository: String?,
    var Follower: String?,
    var Following: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeValue(avatar)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(repository)
        parcel.writeString(Follower)
        parcel.writeString(Following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}