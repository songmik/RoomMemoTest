package com.example.roommemotest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class MemoDataBase : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {
        private var instance: MemoDataBase ?= null

        fun getInstance(context: Context): MemoDataBase? {
            if (instance == null) {
                synchronized(MemoDataBase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDataBase::class.java,
                        name = "memo_database"
                    ).build()
                }
            }
            return instance
        }
    }
}