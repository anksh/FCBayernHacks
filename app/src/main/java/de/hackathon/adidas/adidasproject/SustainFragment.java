package de.hackathon.adidas.adidasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SustainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sustain_fragment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.findManuallyBtn)
    protected void findManually() {
        Toast.makeText(getActivity(), "Find manually", Toast.LENGTH_SHORT).show();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //transaction.replace(((ViewGroup) getView().getParentForAccessibility()).getId(), new FindManuallyFragment());
        transaction.add(((ViewGroup) getView().getParentForAccessibility()).getId(), new FindManuallyFragment());

        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.sustainCameraBtn)
    protected void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
}