ipackage to.msn.wings.fortune_app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// TODO 画面固定を追加
// TODO トースト表示「おみくじと入力して下さい」を追加
// TODO 乱数調整
// TODO 「おみくじ」以外が入力された時の例外処理

// TODO ルーズリーフ参照

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 画面が破棄される前に状態を保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView txtResult = findViewById(R.id.txtResult);
        outState.putString("txtResult", txtResult.getText().toString());
    }

    // 画面が復元される際に状態を取り出し
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(savedInstanceState.getString("txtResult"));
    }
}