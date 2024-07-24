package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }

    }
}

private val contacts = listOf(
    Contact(
        name = "Ana",
        phone = "(11) 98765-4321",
        icon = R.drawable.sample6
    ),
    Contact(
        name = "Bruno",
        phone = "(21) 91234-5678",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Carlos",
        phone = "(31) 92345-6789",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Daniel",
        phone = "(41) 93456-7890",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Fernanda",
        phone = "(51) 94567-8901",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Gabriel",
        phone = "(61) 95678-9012",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Isabela",
        phone = "(71) 96789-0123",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Juliana",
        phone = "(81) 97890-1234",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Mariana",
        phone = "(91) 98901-2345",
        icon = R.drawable.sample16
    ),
    Contact(
        name = "Ricardo",
        phone = "(19) 99012-3456",
        icon = R.drawable.sample8
    )
)