package com.rismandev.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvCompany: TextView = findViewById(R.id.tv_company)
        val imgAvatar: CircleImageView = findViewById(R.id.img_avatar)
        val tvFollower: TextView = findViewById(R.id.tv_follower)
        val tvFollowing: TextView = findViewById(R.id.tv_following)

        val user = intent.getParcelableExtra(EXTRA_USER) as User

        tvName.text = user.name.toString()
        tvUsername.text = user.username.toString()
        tvLocation.text = user.location.toString()
        tvCompany.text = user.company.toString()
        user.avatar?.let { imgAvatar.setImageResource(it) }
        tvFollower.text = user.Follower.toString()
        tvFollowing.text = user.Following.toString()
    }
}
