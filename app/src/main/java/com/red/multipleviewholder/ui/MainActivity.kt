package com.red.multipleviewholder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.red.multipleviewholder.R
import com.red.multipleviewholder.model.Component
import com.red.multipleviewholder.ui.adapters.ComponentsAdapter
import com.red.multipleviewholder.utils.rawToModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val (metadata, components) = rawToModel(R.raw.hub) ?: return

        setupTopAppBar(metadata)
        setupRecycler(components)
    }

    private fun setupTopAppBar(metadata: Map<String, String>) {
        findViewById<MaterialToolbar>(R.id.topAppBar).apply {
            title = metadata["title"]
            subtitle = metadata["description"]
        }
    }

    private fun setupRecycler(components: List<Component>) {
        val recycler = findViewById<RecyclerView>(R.id.components_recycler)
        val adapter = ComponentsAdapter(components)
        val layoutManager = LinearLayoutManager(this)

        recycler.adapter = adapter
        recycler.layoutManager = layoutManager
    }

}