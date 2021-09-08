package ml.leoforney.simplelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.DialogInterface
import android.text.InputType

import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var newItemButton: Button
    var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.listRecyclerView)
        newItemButton = findViewById(R.id.newItemButton)

        rv.layoutManager = LinearLayoutManager(this)
        adapter = Adapter()
        rv.adapter = adapter

        newItemButton.setOnClickListener {
            showNewItemDialog()
        }

    }

    private fun showNewItemDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Add new item")

        val input = EditText(this)

        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK"
        ) { _, _ -> adapter?.addItem(input.text.toString()) }
        builder.setNegativeButton("Cancel"
        ) { dialog, _ -> dialog.cancel() }

        builder.show()
    }


    class Adapter() :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        var dataSet: MutableList<String> = mutableListOf()

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(android.R.id.text1)

        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(android.R.layout.simple_list_item_1, viewGroup, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.textView.text = dataSet[position]
        }

        override fun getItemCount() = dataSet.size

        fun addItem(newString: String) {
            dataSet.add(newString)
            notifyDataSetChanged()
        }

    }


}