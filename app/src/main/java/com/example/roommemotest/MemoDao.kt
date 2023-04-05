package com.example.roommemotest

import androidx.room.*

@Dao
interface MemoDao {

    @Query("SELECT * FROM memo")
    fun getAll() : List<Memo>

    @Insert
    fun insert(memo: Memo)

    @Update
    fun update(memo: Memo)

    @Delete
    fun delete(memo: Memo)
}