package p.a.capstoneproject;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpeger_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adding fragment

        adapter.addFragment(new FragmentHome(),"Home");
        adapter.addFragment(new FragmentCategory(),"Category");

        //adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.profile){
            Toast.makeText(this, "You clicked PROFILE", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.settings){
            Toast.makeText(this, "You clicked SETTINGS", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.help){
            Toast.makeText(this, "You clicked HELP", Toast.LENGTH_SHORT).show();

        }else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
