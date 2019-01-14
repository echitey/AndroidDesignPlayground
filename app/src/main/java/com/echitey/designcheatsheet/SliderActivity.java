package com.echitey.designcheatsheet;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.echitey.designcheatsheet.adapters.SliderAdapter;

public class SliderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private int currentPage;
    private Button btnPrev, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.linearLayout);

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrevious);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicators(0);

        viewPager.addOnPageChangeListener(viewListener);
    }

    private void addDotsIndicators(int position) {

        mDots = new TextView[3];
        linearLayout.removeAllViews();

        for(int i = 0; i< mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transp));

            linearLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.white));

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicators(position);

            currentPage = position;

            if(position == 0){
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.INVISIBLE);

                btnNext.setText("NEXT");

            } else if(position == mDots.length-1){

                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.INVISIBLE);

                btnNext.setText("FINISH");
            } else {

                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);

                btnNext.setText("NEXT");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void openPrevious(View view) {
        viewPager.setCurrentItem(currentPage - 1);
    }

    public void openNext(View view) {
        viewPager.setCurrentItem(currentPage + 1);
    }
}
