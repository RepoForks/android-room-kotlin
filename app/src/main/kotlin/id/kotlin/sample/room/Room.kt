package id.kotlin.sample.room

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import id.kotlin.sample.room.data.Database
import id.kotlin.sample.room.extensions.objectOf
import android.arch.persistence.room.Room as RoomDB

class Room : Application() {

    override fun onCreate() {
        super.onCreate()

        val database = RoomDB.databaseBuilder(this, objectOf<Database>(), "room_sample.db")
        database.build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}