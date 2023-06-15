package github.mik0war.deliveryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.mik0war.category.di.CategorySubComponent
import github.mik0war.category.di.CategorySubComponentProvider
import github.mik0war.category.presentation.ChangeActivityTitle
import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.deliveryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    CategorySubComponentProvider,
    FillShoppingCartSubComponentProvider
    , ChangeActivityTitle {

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

    fun setBottomNavigationViewItemSelected(itemId: Int){
        var position: Int? = null

        bottomNavigationView?.let {
            it.menu.forEachIndexed { index, item ->
                if (item.itemId == itemId)
                    position = index
            }
        }

        position?.let{ pos ->
            bottomNavigationView?.let{
                it.menu.getItem(pos).isChecked = true
            }
        }
    }

    override fun provideCategorySubComponent(): CategorySubComponent =
        (application as DeliveryApp).provideCategorySubComponent()

    override fun changeTitle(newTitle: String, buttonListener: () -> Unit) {
    }

    override fun provideFillShoppingCartSubComponent() =
        (application as DeliveryApp).provideFillShoppingCartSubComponent()
}