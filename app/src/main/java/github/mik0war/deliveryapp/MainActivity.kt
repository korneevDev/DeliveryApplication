package github.mik0war.deliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.mik0war.category.presentation.ChangeActivityTitle
import github.mik0war.deliveryapp.databinding.ActivityMainBinding
import github.mik0war.dish.presentation.BottomNavigationSetSelected

class MainActivity : AppCompatActivity(),
    BottomNavigationSetSelected,
    ChangeActivityTitle {

    private lateinit var binding: ActivityMainBinding
    private var bottomNavigationView: BottomNavigationView? = null

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
        bottomNavigationView?.setupWithNavController(navController)
    }

    override fun setBottomNavigationViewItemSelected(position: Int){
            bottomNavigationView?.let{
                it.menu.getItem(position).isChecked = true
            }
    }

    override fun changeTitle(newTitle: String, buttonListener: () -> Unit) {
    }
}