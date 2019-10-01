package xu.morgan.clockapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import xu.morgan.clockapp.model.Clock;
import xu.morgan.clockapp.view.ClockAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvClocks;
    private FloatingActionButton fabEdit;
    private ClockAdapter clockAdapter;
    private ArrayList<Clock> clocks;
    private static final Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvClocks = (RecyclerView) findViewById(R.id.rvClocks);
        fabEdit = (FloatingActionButton) findViewById(R.id.fab);
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEditClick();
            }
        });
        rvClocks.setLayoutManager(new LinearLayoutManager(this));
        clocks = new ArrayList<>();
        clockAdapter = new ClockAdapter(this, clocks);
        rvClocks.setAdapter(clockAdapter);
        populateClocks();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Clock clock : clocks) {
                    clock.updateTime();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        clockAdapter.notifyDataSetChanged();
                    }
                });
            }
        }, 0, 1000);
    }

    private void populateClocks() {
        Clock sydney = new Clock("Australia/Sydney", "Sydney", "sydney");
        clocks.add(sydney);

        Clock paris = new Clock("Europe/Paris", "Paris", "paris");
        clocks.add(paris);

        Clock london = new Clock("Europe/London", "London", "london");
        clocks.add(london);

        Clock moscow = new Clock("Europe/Moscow", "Moscow", "moscow");
        clocks.add(moscow);

        Clock rome = new Clock("Europe/Rome", "Rome", "rome");
        clocks.add(rome);

        Clock cairo = new Clock("Africa/Cairo", "Cairo", "cairo");
        clocks.add(cairo);

        Clock newDelhi = new Clock("Asia/Kolkata", "New Delhi", "newdelhi");
        clocks.add(newDelhi);

        Clock toronto = new Clock("America/Toronto", "Toronto", "toronto");
        clocks.add(toronto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (clockAdapter.getFormat()){
            case TWELVE:
                menu.findItem(R.id.action_switch_format).setTitle(R.string.settings_12);
                break;
            case TWENTYFOUR:
                menu.findItem(R.id.action_switch_format).setTitle(R.string.settings_24);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_switch_format:
                clockAdapter.switchFormat();
                invalidateOptionsMenu();
                clockAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void onEditClick() {
        Intent intent = new Intent();
        
    }
}
