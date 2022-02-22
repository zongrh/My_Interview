package cn.my.interview.ui.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.my.interview.R;

public class TestMvpActivity extends AppCompatActivity implements MVPView {
    private Button button;
    private TextView textView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        button = findViewById(R.id.btn_mvp_button);
        textView = findViewById(R.id.text_mvp_view);
        presenter = new Presenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.request();
            }
        });

    }

    @Override
    public void updateTv(String text) {
        textView.setText(text);
    }
}