package com.example.lab9.adapters
import com.example.lab9.data.datasource.model.variouscharacters.Result
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.lab9.R

class CharacterAdapter(
    private val characters:MutableList<Result>,
    private val listener: PlaceListener
    ):RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    interface PlaceListener{
        fun onPlaceClicked(data: Result, position: Int)
    }
    class ViewHolder(private val view: View,
                     private val listener: PlaceListener
    ):
        RecyclerView.ViewHolder(view){
        private val image = view.findViewById<ImageView>(R.id.ivchar_charactersFragment)
        private val name = view.findViewById<TextView>(R.id.name_char_charactersFragment)
        private val characteristics = view.findViewById<TextView>(R.id.characteristics_char_charactersFragment)
        private val layout: ConstraintLayout = view.findViewById(R.id.layoutitemrecycler_charactersfragment)
        fun bind(character: Result){
            image.load(character.image){
                transformations(CircleCropTransformation())
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
                error(R.drawable.ic_baseline_error_24)
                placeholder(R.drawable.ic_baseline_replay_24)
            }
            name.text = character.name
            characteristics.text = character.status
            setListeners(character)
        }
        private fun setListeners(character: Result){
            layout.setOnClickListener {
                listener.onPlaceClicked(character, this.adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):
            ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemrecycler_charactersfragment, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

}