package com.sevent.seventapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.sevent.seventapp.Adapter.TimelineAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gizmo on 06/11/2016.
 */
public class TimelineFrag extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    Spinner sp;
    private SliderLayout mSlider;
    private final String Title_Event[] = {
            "Konser Amal", "Konser Rock", "Akustikan", "DJ Marshmellow", "Festival Kuliner"
    };
    private final String Lokasi[] = {
            "Sasana Budaya Ganesha","Lapangan Supratman", "Gasibu", "Trans Studio Bandung", "Tegalega"
    };
    private final String Tanggal[] = {
            "12 NOV 2016","14 NOV 2016", "23 DES 2016", "5 JAN 2017", "2 FEB 2017"
    };
    int image[] = {R.drawable.health2, R.drawable.rock2, R.drawable.acoustic2,R.drawable.mas,R.drawable.kuliner};
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_timeline,container,false);
        mSlider = (SliderLayout)v.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Konser Rock",R.drawable.rock2 );
        file_maps.put("Peduli Sesama",R.drawable.health2 );
        file_maps.put("Akustikan", R.drawable.acoustic2);
        file_maps.put("Festival Kuliner",R.drawable.health2 );

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(5000);
        mSlider.addOnPageChangeListener(this);


        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rvTimeline);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lm);

        ArrayList timeline = prepareData();
        TimelineAdapter adapter = new TimelineAdapter(getActivity(), timeline);
        recyclerView.setAdapter(adapter);

        sp = (Spinner) v.findViewById(R.id.spKota);
        List<String> kota = new ArrayList<String>();
        kota.add("Bandung");
        kota.add("Jakarta");
        kota.add("Surabaya");
        kota.add("Yogyakarta");
        kota.add("Denpasar");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, kota);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);

        return v;
    }

    private ArrayList prepareData() {
        ArrayList time_line = new ArrayList();
        for(int i=0; i < Title_Event.length; i++){
            Timeline timeline = new Timeline();
            timeline.setTitle(Title_Event[i]);
            timeline.setLokasi(Lokasi[i]);
            timeline.setTanggal(Tanggal[i]);
            timeline.setImage(image[i]);
            time_line.add(timeline);
        }
        return time_line;
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
