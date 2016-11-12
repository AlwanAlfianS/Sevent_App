package com.sevent.seventapp.Adapter;

import android.view.View;

import com.daimajia.androidanimations.library.attention.StandUpAnimator;
import com.daimajia.slider.library.Animations.BaseAnimationInterface;

/**
 * Created by Gizmo on 11/11/2016.
 */
public class ChildAnimation implements BaseAnimationInterface {
    @Override
    public void onPrepareCurrentItemLeaveScreen(View current) {
        View description = current.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(description!=null){
            current.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPrepareNextItemShowInScreen(View next) {
        View description = next.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(description!=null){
            next.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCurrentItemDisappear(View view) {

    }

    @Override
    public void onNextItemAppear(View view) {
        View description = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(description!=null){
            view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.VISIBLE);
            new StandUpAnimator().animate(description);
        }
    }
}
