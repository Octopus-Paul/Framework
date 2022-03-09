package ru.iis.framework;

import static ru.iis.framework.utils.Constants.MENU_CLICKER;
import static ru.iis.framework.utils.Constants.MENU_INITIATIVE;
import static ru.iis.framework.utils.Constants.MENU_KNOWLEDGE;
import static ru.iis.framework.utils.Constants.MENU_OFF;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnm;
    public NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnm = findViewById(R.id.bottomNavigationView);

        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host);
        NavigationUI.setupWithNavController(bnm,
                Objects.requireNonNull(navHostFragment).getNavController());
        navController = navHostFragment.getNavController();
    }

    //Настройка навигации bnm
    public void setMenu(int type) {
        bnm.setOnItemSelectedListener(null);
        bnm.setVisibility(View.VISIBLE);
        if (type == MENU_OFF) {
            bnm.setVisibility(View.GONE);
            return;
        } else {
            bnm.setSelectedItemId(type);
        }
        bnm.setVisibility(View.VISIBLE);
        bnm.setOnItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case MENU_CLICKER:
                    navController.navigate(R.id.clickerFragment);
                    break;
                case MENU_INITIATIVE:
                    navController.navigate(R.id.initiaiveFragment);
                    break;
                case MENU_KNOWLEDGE:
                    navController.navigate(R.id.knowledgeFragment);
                    break;
            }
            return false;
        });
    }
}