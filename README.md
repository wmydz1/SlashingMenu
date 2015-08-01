# SlashingMenu

![Alt text](http://7xir7h.com1.z0.glb.clouddn.com/coolmenu.png)


### xml 
```

<com.logoocc.slashingmenu.SlashingMenu
    android:id="@+id/main_sm"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>

```

### java

```

sm = (SlashingMenu) findViewById(R.id.main_sm);
sm.setSlashingMenuItemClickListener(clickLis);

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
    
    

```

