package github.mik0war.deliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.mik0war.deliveryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dish,
                R.id.navigation_cart
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }

    fun setBottomNavigationViewItemSelected(itemId: Int){
        var position: Int? = null

        bottomNavigationView.menu.forEachIndexed { index, item ->
            if(item.itemId == itemId)
                position = index
        }

        position?.let{bottomNavigationView.menu.getItem(it).isChecked = true}
    }
}