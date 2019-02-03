package welcomeandroid.myandroidhello.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE=1;

    private Button myButton;
    private EditText myEditText;
    private TextView myTextView;
    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton= (Button) findViewById(R.id.button);
        myEditText=(EditText) findViewById(R.id.editText) ;
        myTextView= (TextView) findViewById(R.id.textView2);
        showButton= (Button) findViewById(R.id.button2);



        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName=null;
                myName=myEditText.getText().toString();
                myTextView.setText(myName);
            }
        });


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("activityOne", "I have come from 1st activity");

                startActivityForResult(intent ,REQUEST_CODE);

                //startActivity(intent);

                //startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                String result= data.getStringExtra("returnData");
                Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}

