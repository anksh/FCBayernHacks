package de.hackathon.adidas.adidasproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SustainFragment extends Fragment {

    private View view;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.sustain_fragment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    final int CAMERA_CAPTURE = 1;

    @OnClick(R.id.sustainCameraBtn)
    protected void openCamera() {
      /*  //ONLY FOR TESTS!!!!!!!!!!!!!!!!!!!!!
        Intent myIntent = new Intent(getActivity(), SustainDetailsActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        getActivity().startActivity(myIntent);
        //ONLY FOR TESTS!!!!!!!!!!!!!!!!!!!!!*/


        try{
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, CAMERA_CAPTURE);
        }catch (ActivityNotFoundException anfe){
            String errorMessage = "your device doesn't support capturing images :(";
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        Intent myIntent = new Intent(getActivity(), SustainDetailsActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        getActivity().startActivity(myIntent);

    }
}

