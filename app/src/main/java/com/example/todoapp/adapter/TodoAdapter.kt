package com.example.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.Todo


class TodoAdapter(private val context: Context,
                        private val dataset:MutableList<Todo>)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val descriptionTextView: TextView = view.findViewById(R.id.card_description_textview)
        val deleteButton: Button = view.findViewById<Button>(R.id.delete_button)
    }

    fun addTodo(newTodo: String) {
        dataset.add(Todo(newTodo))
        notifyItemInserted(dataset.size - 1)
    }

    private fun deleteTodo(todo: Todo) {
        if(dataset.remove(todo)){
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_card_item, parent, false)
        return TodoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = dataset[position]
        holder.descriptionTextView.text = todo.stringExample
        holder.deleteButton.setOnClickListener {
            deleteTodo(todo)
        }
    }

    override fun getItemCount() = dataset.size
}