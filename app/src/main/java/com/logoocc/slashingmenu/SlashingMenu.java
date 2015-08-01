package com.logoocc.slashingmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by samchen on 8/1/15.
 */
public class SlashingMenu extends RelativeLayout {
    private ImageView menubt;
    private RelativeLayout menu;

    private boolean isOpen;
    private Animation open;
    private Animation close;
    private Animation big;
    private Animation small;

    private ImageView lv1;
    private ImageView lv2;
    private ImageView lv3;
    private ImageView lv4;
    private ImageView lv5;

    private OnSlashingMenuItemClickListener itemClickLis;

    public SlashingMenu(Context context) {
        super(context);
        init(null);
    }

    public SlashingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SlashingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.slashing_menu, this);

        menubt = (ImageView) findViewById(R.id.menu_bt);
        menu = (RelativeLayout) findViewById(R.id.menu);
        open = AnimationUtils.loadAnimation(getContext(), R.anim.anim_menu_rotate);
        close = AnimationUtils.loadAnimation(getContext(), R.anim.anim_menu_rotate_2);

        big = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_big);
        small = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_small);

        lv1 = (ImageView) findViewById(R.id.menu_1);
        lv2 = (ImageView) findViewById(R.id.menu_2);
        lv3 = (ImageView) findViewById(R.id.menu_3);
        lv4 = (ImageView) findViewById(R.id.menu_4);
        lv5 = (ImageView) findViewById(R.id.menu_5);

        menubt.setOnClickListener(clickLis);

        for (int i = 0; i < menu.getChildCount(); i++) {
            menu.getChildAt(i).setOnClickListener(clickLis);
        }

    }

    private View.OnClickListener clickLis = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.menu_bt:
                    if (isOpen) {
                        v.startAnimation(close);
                    } else {
                        v.startAnimation(open);
                    }
                    startAnimation(menu, !isOpen);
                    isOpen = !isOpen;
                    break;
                case R.id.menu_1:
                    startHideAnimation(0);
                    if (itemClickLis!=null){
                        itemClickLis.onItemClick(lv1,SlashingMenu.this);
                    }
                    break;
                case R.id.menu_2:
                    startHideAnimation(1);
                    if (itemClickLis!=null){
                        itemClickLis.onItemClick(lv2,SlashingMenu.this);
                    }
                    break;
                case R.id.menu_3:
                    startHideAnimation(2);
                    if (itemClickLis!=null){
                        itemClickLis.onItemClick(lv3,SlashingMenu.this);
                    }
                    break;
                case R.id.menu_4:
                    startHideAnimation(3);
                    if (itemClickLis!=null){
                        itemClickLis.onItemClick(lv4,SlashingMenu.this);
                    }
                    break;
                case R.id.menu_5:
                    startHideAnimation(4);
                    if (itemClickLis!=null){
                        itemClickLis.onItemClick(lv5,SlashingMenu.this);
                    }
                    break;
            }
        }
    };

    private void startHideAnimation(int index) {
        isOpen = false;
        menubt.startAnimation(close);
        for (int i = 0; i < menu.getChildCount(); i++) {
            View v = menu.getChildAt(i);
            if (i == index) {
                v.startAnimation(big);
            } else {
                v.startAnimation(small);
            }
            v.setVisibility(View.GONE);
        }
    }

    private void startAnimation(ViewGroup vg, boolean isOpen) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            Animation animation = null;
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();

            if (isOpen) {
                v.setVisibility(View.VISIBLE);
                animation = new TranslateAnimation(-lp.leftMargin, 0, lp.bottomMargin, 0);
                animation.setStartOffset(i * 30);
                animation.setInterpolator(new OvershootInterpolator(2f));
            } else {
                v.setVisibility(View.GONE);
                animation = new TranslateAnimation(0, -lp.leftMargin, 0, lp.bottomMargin);
                animation.setStartOffset((vg.getChildCount() - 1 - i) * 30);
                animation.setInterpolator(new AnticipateInterpolator(2f));
            }
            animation.setDuration(400);
            animation.setFillAfter(true);

            v.startAnimation(animation);
        }
    }

    public interface OnSlashingMenuItemClickListener {
        void onItemClick(ImageView lv, View view);
    }

    public void setSlashingMenuItemClickListener(OnSlashingMenuItemClickListener clickLis) {
        this.itemClickLis = clickLis;
    }
}
