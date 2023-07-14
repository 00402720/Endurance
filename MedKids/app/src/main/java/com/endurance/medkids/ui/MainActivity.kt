package com.endurance.medkids.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.endurance.medkids.R
import com.endurance.medkids.databinding.ActivityMainBinding
import com.endurance.medkids.ui.infoView.ContentView
import com.endurance.medkids.ui.profile.perfil

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      /*  actionBar = supportActionBar!!
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setCustomView(R.menu.menu)
        val actionProfile = actionBar.customView.findViewById<View>(R.id.usuario)
        val actionHome = actionBar.customView.findViewById<View>(R.id.home)

        actionProfile.setOnClickListener {
         }*/



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

                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



    private fun abrirFragmentoPerfil() {
        // Reemplazar el código para abrir el fragmento de perfil
        val perfilFragment = perfil()
        supportFragmentManager.beginTransaction()
            .replace(R.id.profile, perfilFragment)
            .commit()
    }

    private fun abrirFragmentoInicio() {
        // Reemplazar el código para abrir el fragmento de inicio
        val inicioFragment = ContentView()
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentView, inicioFragment)
            .commit()
    }


}