package com.example.sanzarouth.tddtest.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sanzarouth.tddtest.ModelView.CalculatorViewModel;
import com.example.sanzarouth.tddtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.number1)
    EditText number1;

    @BindView(R.id.number2)
    EditText number2;

    @BindView(R.id.resultView)
    TextView resultView;

    CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
        displayClickCount(viewModel.getResult());
    }


    @OnClick({R.id.addBtn, R.id.subBtn, R.id.multBtn, R.id.divBtn})
    public void add(View button) {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());

        switch (button.getId()) {
            case R.id.addBtn:
                viewModel.add(num1, num2);
                break;
            case R.id.subBtn:
                viewModel.subtract(num1, num2);
                break;
            case R.id.multBtn:
                viewModel.multiply(num1, num2);
                break;
            case R.id.divBtn:
                viewModel.divide(num1, num2);
                break;
        }

        displayClickCount(viewModel.getResult());
    }

    @OnClick(R.id.advancedBtn)
    public void openAdvancedCalc() {
        Intent advancedIntent = new Intent(getApplicationContext(), AdvancedActivity.class);
        startActivity(advancedIntent);

    }

    private void displayClickCount(double clickCount) {
        resultView.setText(String.valueOf(clickCount));
    }

}
