package de.hackathon.adidas.adidasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SustainDetailsActivity extends AppCompatActivity {

    @OnClick(R.id.editText43)
    protected void showSnackbarOnClickSubmit(){
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.nestedScrollView), "Submitted! Check your email for details", Snackbar.LENGTH_SHORT)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        snackbar.show();
        redirectToHomePage();
    }

    private void redirectToHomePage(){
        Intent myIntent = new Intent(this, MainActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        SustainDetailsActivity.this.startActivity(myIntent);
        SustainDetailsActivity.this.finish();
        //ONLY FOR TESTS!!!!!!!!!!!!!!!!!!!!!*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_sustain_details);
        ButterKnife.bind(this);
    }
}
