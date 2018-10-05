package com.example.sanzarouth.tddtest.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sanzarouth.tddtest.ModelView.AdvancedCalculatorViewModel;
import com.example.sanzarouth.tddtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdvancedActivity extends AppCompatActivity {

    AdvancedCalculatorViewModel viewModel;

    @BindView(R.id.advancedResultView)
    TextView advancedTextView;

    @BindView(R.id.advancedInput)
    EditText advancedInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(AdvancedCalculatorViewModel.class);

    }

    @OnClick(R.id.calculateBtn)
    public void evaluateExpression() {
        viewModel.calculate(advancedInput.getText().toString());
        advancedTextView.setText(String.valueOf(viewModel.getResult()));
    }

}
