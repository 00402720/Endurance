package com.endurance.medkids.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.endurance.medkids.R
import com.endurance.medkids.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuItem = menu.findItem(R.id.home)
        val drawable = ContextCompat.getDrawable(this, R.drawable.baseline_home_24)
        drawable?.setBounds(0, 0, 60, 60) // Ajusta el tamaño del ícono según tus preferencias

        val spannableString = SpannableString(menuItem.title)
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)
        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        menuItem.title = spannableString

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                // Acción a realizar cuando se selecciona el ícono del menú
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }





}