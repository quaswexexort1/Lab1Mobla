package com.example.lab1.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab1.data.model.ToDoItem

@Dao
interface ToDoDatabaseDAO {
    @Query("select * from my_todo_list")
    fun getAll(): LiveData<List<ToDoItem>>

    @Query("select * from my_todo_list where itemId = :id")
    fun getById(id: Int): ToDoItem?

    @Insert
    suspend fun insert(item: ToDoItem)

    @Update
    suspend fun update(item: ToDoItem)

    @Delete
    suspend fun delete(item: ToDoItem)

    @Query("delete from my_todo_list")
    suspend fun deleteTodos()
}