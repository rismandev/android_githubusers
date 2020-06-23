package com.rismandev.githubusers

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import java.text.FieldPosition
import java.text.ParsePosition

class MainActivity : AppCompatActivity()
{
    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter
        // Prepare Function
        prepare()
        // Add Item Function
        addItem()
        // onClick List Item
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
            moveIntent.putExtra(DetailActivity.EXTRA_USER, users[position])
            startActivity(moveIntent)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getStringArray(R.array.data_repository)
        dataFollower = resources.getStringArray(R.array.data_follower)
        dataFollowing = resources.getStringArray(R.array.data_following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataName[position],
                dataUsername[position],
                dataAvatar.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )

            users.add(user)
        }
        adapter.users = users
    }

}
