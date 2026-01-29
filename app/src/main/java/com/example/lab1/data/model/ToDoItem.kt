package com.example.lab1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("my_todo_list")
data class ToDoItem(
    @PrimaryKey(true)
    var itemId: Long = 0L,

    @ColumnInfo("item_name")
    val itemName: String,

    @ColumnInfo("is_completed")
    var isDone: Boolean = false
)