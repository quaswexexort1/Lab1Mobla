package com.example.lab1.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab1.data.DAO.ToDoDatabaseDAO
import com.example.lab1.data.model.ToDoItem


@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase(){
    abstract fun todoDao(): ToDoDatabaseDAO
    companion object{
        private var INSTANCE: ToDoDatabase?= null

        fun getInstance(context: Context): ToDoDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(context.applicationContext,
                        ToDoDatabase::class.java, "todo_list_db").fallbackToDestructiveMigration(false).build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}