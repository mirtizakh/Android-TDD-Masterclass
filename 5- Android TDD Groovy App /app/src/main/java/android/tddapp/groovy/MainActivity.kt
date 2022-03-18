package android.tddapp.groovy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.tddapp.groovy.playlists.PlaylistFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PlaylistFragment.newInstance())
        }
    }
}