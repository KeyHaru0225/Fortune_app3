package to.msn.wings.fortune_app3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log; //6/11追加
import android.view.View;
import android.widget.Button; //6/11追加
import android.widget.TextView;
import android.widget.Toast;

// TODO 画面固定を追加　済
// TODO トースト表示「おみくじと入力して下さい」を追加 済
// TODO 乱数調整　済


// TODO 「おみくじ」以外が入力された時の例外処理　済？

// TODO ルーズリーフ参照

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.send_message);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView txt = findViewById(R.id.user_message);
                        txt.setText(toastMessage);
                    }
                }
        );
    }

    // 画面が破棄される前に状態を保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView txtResult = findViewById(R.id.user_message);
        outState.putString("txtResult", txtResult.getText().toString());
    }

    // 画面が復元される際に状態を取り出し
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txtResult = findViewById(R.id.user_message);
        txtResult.setText(savedInstanceState.getString("txtResult"));
    }
        // Toast表示

        String toastMessage = "「おみくじと入力」";

        public void btnCurrent_onClick (View view){
            TextView txt = findViewById(R.id.txtResult);
            txt.setText(toastMessage);

            Toast toast = Toast.makeText(
                    this, toastMessage, Toast.LENGTH_LONG);
            toast.show();
        }




    // おみくじ
    public void onClick(View v) {  // TODO v をViewに変更すべきか
        if(v.equals(mSendMessage)) {
            // SENDボタンが押された時の処理
            String inputText = mInputMessage.getText().toString();
            String answer;
            mUserMessage.setText(inputText);
            if (inputText.contains("おみくじ")) {
                double random = Math.random() * 5d;
                if (random < 1d) {
                    answer = "大凶";
                } else if (random < 2d) {
                    answer = "凶";
                } else if (random < 3d) {
                    answer = "吉";
                } else if (random < 4d) {
                    answer = "中吉";
                } else {
                    answer = "大吉";
                }
            } else {
                System.out.println("「おみくじ」と入力して下さい");
            }
        }
    }

}