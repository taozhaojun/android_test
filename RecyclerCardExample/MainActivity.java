package com.ben.recyclercardexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        RecyclerView my_recycler = findViewById(R.id.my_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.menu_like){
                    Toast.makeText(getSupportActionBar().getThemedContext(), "Like is clicked", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });


        ArrayList<Movie> data = new ArrayList<>();
        data.add(new Movie("A Man Called Otto", R.drawable.a_man, "7.5/10", 2022, "Otto is a grump who's given up on life following the loss of his wife and wants to end it all. When a young family moves in nearby, he meets his match in quick-witted Marisol, leading to a friendship ..."));
        data.add(new Movie("Harry Spotter, the boy who lifted", R.drawable.harry, "9.5/10", 2023, "The Boy Who Lifted is a bold reimagining of the classic Harry Potter series. Harry’s second year at Hogwarts School of Fitness and Wizardry introduces new challenges and magical gains. A mysterious set of forbidden weights is discovered in the hidden Chamber of Muscles."));
        data.add(new Movie("The Matrix", R.drawable.matrix, "9/10", 1999, "When computer programmer Thomas Anderson, under the hacker alias \"Neo\", uncovers the truth, he joins a rebellion against the machines along with other people who have been freed from the Matrix."));
        data.add(new Movie("The Godfather", R.drawable.god, "9/10", 1972, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."));
        data.add(new Movie("Die Hard", R.drawable.die, "8.2/10", 1988, "A New York City police officer tries to save his estranged wife and several others taken hostage by terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles."));
        data.add(new Movie("A Man Called Otto", R.drawable.a_man, "7.5/10", 2022, "Otto is a grump who's given up on life following the loss of his wife and wants to end it all. When a young family moves in nearby, he meets his match in quick-witted Marisol, leading to a friendship ..."));
        data.add(new Movie("Harry Spotter, the boy who lifted", R.drawable.harry, "9.5/10", 2023, "The Boy Who Lifted is a bold reimagining of the classic Harry Potter series. Harry’s second year at Hogwarts School of Fitness and Wizardry introduces new challenges and magical gains. A mysterious set of forbidden weights is discovered in the hidden Chamber of Muscles."));
        data.add(new Movie("The Matrix", R.drawable.matrix, "9/10", 1999, "When computer programmer Thomas Anderson, under the hacker alias \"Neo\", uncovers the truth, he joins a rebellion against the machines along with other people who have been freed from the Matrix."));
        data.add(new Movie("The Godfather", R.drawable.god, "9/10", 1972, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."));
        data.add(new Movie("Die Hard", R.drawable.die, "8.2/10", 1988, "A New York City police officer tries to save his estranged wife and several others taken hostage by terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles."));
        data.add(new Movie("A Man Called Otto", R.drawable.a_man, "7.5/10", 2022, "Otto is a grump who's given up on life following the loss of his wife and wants to end it all. When a young family moves in nearby, he meets his match in quick-witted Marisol, leading to a friendship ..."));
        data.add(new Movie("Harry Spotter, the boy who lifted", R.drawable.harry, "9.5/10", 2023, "The Boy Who Lifted is a bold reimagining of the classic Harry Potter series. Harry’s second year at Hogwarts School of Fitness and Wizardry introduces new challenges and magical gains. A mysterious set of forbidden weights is discovered in the hidden Chamber of Muscles."));
        data.add(new Movie("The Matrix", R.drawable.matrix, "9/10", 1999, "When computer programmer Thomas Anderson, under the hacker alias \"Neo\", uncovers the truth, he joins a rebellion against the machines along with other people who have been freed from the Matrix."));
        data.add(new Movie("The Godfather", R.drawable.god, "9/10", 1972, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."));
        data.add(new Movie("Die Hard", R.drawable.die, "8.2/10", 1988, "A New York City police officer tries to save his estranged wife and several others taken hostage by terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles."));


        BenStyleRecyclerAdapter adapter = new BenStyleRecyclerAdapter(data);
        my_recycler.setAdapter(adapter);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            my_recycler.setLayoutManager(manager);
        }else{
            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            my_recycler.setLayoutManager(manager);
        }



    }
}