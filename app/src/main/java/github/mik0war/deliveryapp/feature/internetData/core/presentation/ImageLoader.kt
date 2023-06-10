package github.mik0war.deliveryapp.feature.internetData.core.presentation

import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)

    class Base @Inject constructor() : ImageLoader {
        override fun loadImage(imageUrl: String, imageView: ImageView) {
            Picasso.get()
                .load(imageUrl)
                .into(imageView)
        }
    }
}