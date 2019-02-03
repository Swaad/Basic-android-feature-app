package welcomeandroid.myandroidhello.com.myapplication;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main2Activity extends AppCompatActivity  implements TimePickerDialog.OnTimeSetListener {

    private TextView myText;
    private Button goBackButton;
    private ImageView bikeImage;
    private Button timeButton;

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        TextView textview=(TextView)findViewById(R.id.textViewTime);
                textview.setText("Hour: "+hourOfDay+"Minute: "+minute);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timeButton=(Button) findViewById(R.id.button4);
        myText = (TextView) findViewById(R.id.textview);
        goBackButton= (Button) findViewById(R.id.button3);
        bikeImage= (ImageView) findViewById(R.id.imageView2) ;
        Bundle extras=  getIntent().getExtras();

        if(extras!=null)
        {
            String myString = extras.getString("activityOne");
            myText.setText(myString);
        }

        bikeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setText("This is a good bike");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"   time picker");

            }
        });



        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData" , "From second activity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}













