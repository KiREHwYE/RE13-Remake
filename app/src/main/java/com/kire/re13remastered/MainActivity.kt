package com.kire.re13remastered

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.kire.data.DatabaseUpdater
import com.kire.home.presentation.viewmodel.HomeViewModel
import com.kire.home.presentation.viewmodel.HomeViewModelFactory
import com.kire.ui.composable.BaseLayout
import com.kire.ui.composable.SearchWithMenu
import com.kire.ui.composable.TopBar
import com.kire.ui.theme.RE13RemakeExtendedTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var databaseUpdater: DatabaseUpdater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(Manifest.permission.READ_MEDIA_AUDIO)
        } else {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        ActivityCompat.requestPermissions(
            this,
            permissions,
            0
        )

        appComponent = DaggerAppComponent.builder()
            .bindContext(this)
            .build()
        appComponent.inject(this)

        homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            RE13RemakeExtendedTheme {

                LaunchedEffect(Unit) {
                    launch {
                        databaseUpdater.updateDatabase()
                    }
                }

                val navHostController = rememberNavController()

                BaseLayout(
                    topBar = {
                        TopBar(
                            items = arrayOf(
                                { SearchWithMenu() },
                                { NavigationMenu(navHostController) }
                            )
                        )
                    }
                ) {
                    MainNavHost(
                        navHostController = navHostController,
                        homeViewModel = homeViewModel
                    )
                }
            }
        }
    }
}