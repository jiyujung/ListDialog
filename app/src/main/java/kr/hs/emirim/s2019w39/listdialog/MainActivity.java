package kr.hs.emirim.s2019w39.listdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBasicList, btnRadioList, btnCheckList;
    String[] basicListArr = {"봄", "여름", "가을", "겨울"};
    boolean[] checkArr = {true, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBasicList = findViewById(R.id.btn_basic_list);
        btnBasicList.setOnClickListener(btnListener);

        btnRadioList = findViewById(R.id.btn_radio_list);
        btnRadioList.setOnClickListener(btnListener);

        btnCheckList = findViewById(R.id.btn_check_list);
        btnCheckList.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        AlertDialog.Builder dlg = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_basic_list:
                    dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 계절을 선택하세요.");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setItems(basicListArr, basicListener);
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();
                    break;
                case R.id.btn_radio_list:
                    dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 계절을 선택하세요.");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setSingleChoiceItems(basicListArr, 0, radioListener);
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();
                    break;
                case R.id.btn_check_list:
                    dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 계절을 선택하세요.");
                    dlg.setIcon(R.mipmap.ic_launcher);
                    dlg.setMultiChoiceItems(basicListArr, checkArr, checkListener);
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();
                    break;
            }
        }
    };

    DialogInterface.OnClickListener basicListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnBasicList.setText(basicListArr[which]);
        }
    };

    DialogInterface.OnClickListener radioListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnRadioList.setText(basicListArr[which]);
        }
    };

    DialogInterface.OnMultiChoiceClickListener checkListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if (isChecked)
                btnCheckList.setText(basicListArr[which]);
        }
    };
}