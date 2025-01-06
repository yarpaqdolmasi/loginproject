package com.example.loginproject.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginproject.R
import com.example.loginproject.data.ListItem
import com.example.loginproject.databinding.MainActivityBinding
import com.example.loginproject.presentation.adapters.ClickListener
import com.example.loginproject.presentation.adapters.ItemsListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val adapter by lazy { ItemsListAdapter() }

    private var itemsList = listOf<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        window.statusBarColor = getColor(R.color.teal)
        setContentView(binding.root)
        initList()
        initializeRecycler()
    }

    private fun initList() {
        itemsList = listOf(
            ListItem(
                R.drawable.dolma,
                "Dolma"
            ),
            ListItem(
                R.drawable.dovga,
                "Dovğa"
            ),
            ListItem(
                R.drawable.jizbiz,
                "Cız-bız"
            ),
            ListItem(
                R.drawable.kebab,
                "Kabab"
            ),
            ListItem(
                R.drawable.kufte,
                "Kiftə"
            ),
            ListItem(
                R.drawable.lavangi,
                "Ləvəngi"
            ),
            ListItem(
                R.drawable.pakhlava,
                "Paxlava"
            ),
            ListItem(
                R.drawable.piti,
                "Piti"
            ),
            ListItem(
                R.drawable.plov,
                "Plov"
            ),
            ListItem(
                R.drawable.qutab,
                "Qutab"
            ),
        )
    }

    private fun initializeRecycler() {
        binding.recyclerItems.layoutManager = LinearLayoutManager(this)
        binding.recyclerItems.adapter = adapter
        adapter.setClickListener(object : ClickListener {
            override fun onCLick(position: Int) {
                Toast.makeText(baseContext, "Clicked ${itemsList[position].title}", Toast.LENGTH_SHORT).show()
            }
        })
        adapter.addItems(
            itemsList
        )
    }
}