package com.echitey.designcheatsheet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.echitey.designcheatsheet.R;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context){
        this.context = context;
    }


    public int [] slide_images = {
            R.drawable.male,
            R.drawable.female,
            R.drawable.kids
    };

    public String [] slide_header = {
            "MALE",
            "FEMALE",
            "KIDS"
    };

    public  String [] slide_desc = {
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum  dummy text ever galley of type and scrambled it to make a type specimen book.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever."
    };


    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slideImageView);
        TextView textViewHeader = (TextView) view.findViewById(R.id.slideHeader);
        TextView textViewDesc = (TextView) view.findViewById(R.id.slideDesc);

        imageView.setImageResource(slide_images[position]);
        textViewHeader.setText(slide_header[position]);
        textViewDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);

    }
}
