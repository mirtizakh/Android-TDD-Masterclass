package android.tddapp.groovy.playlists

import android.tddapp.groovy.R
import android.tddapp.groovy.databinding.PlaylistItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyPlaylistsRecyclerViewAdapter(
    private val values: List<Playlists>
) : RecyclerView.Adapter<MyPlaylistsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            PlaylistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.playlistsName.text = item.name
        holder.playlistsCategory.text = item.category
        holder.playlistsImage.setImageResource(R.mipmap.playlist)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val playlistsName: TextView = binding.playlistsName
        val playlistsCategory: TextView = binding.playlistsCategory
        val playlistsImage: ImageView = binding.playlistsImage

    }

}