package com.example.rewechat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment blankFragment=new BlankFragment();
    private Fragment blank1Fragment=new Blank1Fragment();
    private Fragment blank2Fragment=new Blank2Fragment();
    private Fragment blank3Fragment=new Blank3Fragment();
    private ImageView imageView,imageView2,imageView3,imageView4;

    private FragmentManager fragmentManager;
    private LinearLayout LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinerlayoutw);

        LinearLayout1=findViewById(R.id.LinearLayout1);
        LinearLayout2=findViewById(R.id.LinearLayout2);
        LinearLayout3=findViewById(R.id.LinearLayout3);
        LinearLayout4=findViewById(R.id.LinearLayout4);
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);
        initfragment();


    }
    protected void initfragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,blankFragment);
        transaction.add(R.id.id_content,blank1Fragment);
        transaction.add(R.id.id_content,blank2Fragment);
        transaction.add(R.id.id_content,blank3Fragment);
        transaction.commit();
    }

    protected void hidefragment(FragmentTransaction transaction){
        transaction.hide(blankFragment);
        transaction.hide(blank1Fragment);
        transaction.hide(blank2Fragment);
        transaction.hide(blank3Fragment);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LinearLayout1:
                showfragment(0);
                break;
            case R.id.LinearLayout2:
                showfragment(1);
                break;
            case R.id.LinearLayout3:
                showfragment(2);
                break;
            case R.id.LinearLayout4:
                showfragment(3);
                break;
            default:
                break;
        }

    }

    private void chbackc(View view){
        switch(view.getId()){
            case R.id.LinearLayout1:
                LinearLayout1.setBackgroundColor(0xFFFFFF00);
                imageView.setColorFilter(Color.WHITE);
                break;
            case R.id.LinearLayout2:
                LinearLayout2.setBackgroundColor(0xFFFFFF00);
                imageView2.setColorFilter(Color.WHITE);
                break;
            case R.id.LinearLayout3:
                LinearLayout3.setBackgroundColor(0xFFFFFF00);
                imageView3.setColorFilter(Color.WHITE);
                break;
            case R.id.LinearLayout4:
                LinearLayout4.setBackgroundColor(0xFFFFFF00);
                imageView4.setColorFilter(Color.WHITE);
                break;
            default:
                break;
        }
    }

    private void backtoused(View view){
        switch(view.getId()){
            case R.id.LinearLayout1:
                LinearLayout1.setBackgroundColor(0xFF00FF00);
                imageView.setColorFilter(0xFF03DAC5);
                break;
            case R.id.LinearLayout2:
                LinearLayout2.setBackgroundColor(0xFF00FF00);
                imageView2.setColorFilter(0xFF03DAC5);
                break;
            case R.id.LinearLayout3:
                LinearLayout3.setBackgroundColor(0xFF00FF00);
                imageView3.setColorFilter(0xFF03DAC5);
                break;
            case R.id.LinearLayout4:
                LinearLayout4.setBackgroundColor(0xFF00FF00);
                imageView4.setColorFilter(0xFF03DAC5);
                break;
            default:
                break;
        }
    }

    private void showfragment(int i) {
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hidefragment(transaction);
        switch (i){
            case 0:
                transaction.show(blankFragment);
                chbackc(LinearLayout1);
                backtoused(LinearLayout2);
                backtoused(LinearLayout3);
                backtoused(LinearLayout4);
                break;
            case 1:
                transaction.show(blank1Fragment);
                chbackc(LinearLayout2);
                backtoused(LinearLayout1);
                backtoused(LinearLayout3);
                backtoused(LinearLayout4);
                break;
            case 2:
                transaction.show(blank2Fragment);
                chbackc(LinearLayout3);
                backtoused(LinearLayout2);
                backtoused(LinearLayout1);
                backtoused(LinearLayout4);
                break;
            case 3:
                transaction.show(blank3Fragment);
                chbackc(LinearLayout4);
                backtoused(LinearLayout2);
                backtoused(LinearLayout3);
                backtoused(LinearLayout1);
                break;
            default:
                break;
        }
        transaction.commit();
    }

}