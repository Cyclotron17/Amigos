package com.example.amigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView


class todo : AppCompatActivity() {

    lateinit var ad: Button
    lateinit var dl: Button
    lateinit var cl: Button
    lateinit var eitText: EditText
    lateinit var lstView:ListView
    lateinit var totalAns: TextView
    lateinit var performance: TextView
    lateinit var output: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        lstView=findViewById(R.id.listView)
        eitText=findViewById(R.id.editText)
        ad=findViewById(R.id.add)
        dl=findViewById(R.id.delete)
        cl=findViewById(R.id.clear)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)
        // Adding the items to the list when the add button is pressed
        ad.setOnClickListener {

            itemlist.add(eitText.text.toString())
            lstView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            eitText.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        cl.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        lstView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        dl.setOnClickListener {
            val position: SparseBooleanArray = lstView.checkedItemPositions
            val count = lstView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }
    }
}