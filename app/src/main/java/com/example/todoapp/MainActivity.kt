package com.example.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.adapter.TodoAdapter
import com.example.todoapp.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_todo)

        val adapter = TodoAdapter(this, Datasource().loadDefinitions())

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        val addButton = findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            val editText: EditText = findViewById<EditText>(R.id.editText)
            val newTodo: String = editText.text.toString()
            if(newTodo != "" || newTodo != null){
                adapter.addTodo(newTodo)
                editText.text.clear()
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
            }
        }
    }
}