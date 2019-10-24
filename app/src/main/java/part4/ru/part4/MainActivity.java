package part4.ru.part4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import part4.ru.part4.fragments.MainNavigation.BrandsFragment;
import part4.ru.part4.fragments.MainNavigation.SearchFragment;
import part4.ru.part4.fragments.MainNavigation.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    public static String URL_LINK_BRAND_IMAGE = "http://part4.ru/image/brands/";

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_search:
                            loadFragment(SearchFragment.newInstance());
                            return true;
                        case R.id.navigation_brands:
                            loadFragment(BrandsFragment.newInstance());
                            return true;
                        case R.id.navigation_settings:
                            loadFragment(SettingsFragment.newInstance());
                            return true;
                    }
                    return false;
                }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        loadFragment(SearchFragment.newInstance());
    }
}
