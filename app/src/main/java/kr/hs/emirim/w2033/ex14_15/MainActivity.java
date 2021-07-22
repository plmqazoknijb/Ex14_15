package kr.hs.emirim.w2033.ex14_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] fruitsArr = {"수박","딸기","망고"};
    int[] imgsArr = {R.drawable.img01, R.drawable.img02,R.drawable.img03};
    boolean[] checkArr = {true,false,true};
    Button btnFruits;
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDialog = findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(btnListener);
        btnFruits.setOnClickListener(btnListener);
        imgv = findViewById(R.id.imgv);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.dialog_title)
                            .setMessage(R.string.dialog_message)
                            .setIcon(R.drawable.warning)
                            .setPositiveButton(R.string.btn_positive,btnPositiveListener)
                            .show();
                    break;
                case R.id.btn_fruits:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.btn_fruits)
                            .setMultiChoiceItems(fruitsArr,checkArr,fruitsMultiItemListener)
                            .setIcon(R.drawable.watermelon)
                            .setPositiveButton("닫기",null)
                            .show();
                    break;


            }
            /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle(R.string.dialog_title);
            dialog.setMessage(R.string.dialog_message);
            dialog.setIcon(R.drawable.warning);
            dialog.setPositiveButton(R.string.btn_positive,btnPositiveListener);
            dialog.show();*/

        }
    };

    DialogInterface.OnMultiChoiceClickListener fruitsMultiItemListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            btnFruits.setText(fruitsArr[which]);
            imgv.setImageResource(imgsArr[which]);
        }
    };

    DialogInterface.OnClickListener fruitsItemListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnFruits.setText(fruitsArr[which]);
            imgv.setImageResource(imgsArr[which]);
        }
    };

    DialogInterface.OnClickListener btnPositiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this,"대화상자 확인 버튼을 클릭하셨어요.",Toast.LENGTH_SHORT).show();
        }
    };
}