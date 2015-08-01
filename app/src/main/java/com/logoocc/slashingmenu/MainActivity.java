package com.logoocc.slashingmenu;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private SlashingMenu sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SlashingMenu) findViewById(R.id.main_sm);
        sm.setSlashingMenuItemClickListener(clickLis);
    }

    private SlashingMenu.OnSlashingMenuItemClickListener clickLis = new SlashingMenu.OnSlashingMenuItemClickListener() {


        @Override
        public void onItemClick(ImageView lv, View view) {
            switch (lv.getId()){
                case R.id.menu_1:
                    Toast.makeText(MainActivity.this,"1111",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_2:
                    Toast.makeText(MainActivity.this,"2222",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_3:
                    Toast.makeText(MainActivity.this,"3333",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_4:
                    Toast.makeText(MainActivity.this,"4444",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_5:
                    Toast.makeText(MainActivity.this,"5555",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
