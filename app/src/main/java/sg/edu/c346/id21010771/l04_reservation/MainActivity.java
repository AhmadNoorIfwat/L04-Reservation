package sg.edu.c346.id21010771.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvHeader;

    ImageView imageRestaurant;

    TextView tvName;
    EditText etName;

    TextView tvHpNo;
    EditText etHpNo;

    TextView tvGrp;
    Spinner spNoOfPpl;

    ToggleButton tbSmoking;

    TextView tvEmpty1;
    TextView tvDate;
    CalendarView dpDate;
    Button btnDate;
    TextView tvShowDate;

    TextView tvEmpty2;
    TextView tvTime;
    TimePicker tpTime;
    Button btnTime;
    TextView tvShowTime;

    TextView tvEmpty3;

    Button btnReset;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHeader = findViewById(R.id.txtHeader);

        imageRestaurant = findViewById(R.id.txtImageView);

        tvName = findViewById(R.id.txtEnterName);
        etName = findViewById(R.id.etName);

        tvHpNo = findViewById(R.id.txtEnterHpNo);
        etHpNo = findViewById(R.id.etHpNo);

        tvGrp = findViewById(R.id.txtGrpSize);
        spNoOfPpl = findViewById(R.id.spNoOfPeople);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.noOfPpl_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spNoOfPpl.setAdapter(adapter);

        tbSmoking = findViewById(R.id.tbSmoking);

        tvEmpty1 = findViewById(R.id.txtSpace1);
        tvDate = findViewById(R.id.txtChooseDate);
        dpDate = findViewById(R.id.calendarView);
        btnDate = findViewById(R.id.btnDisplayDate);

        tvEmpty2 = findViewById(R.id.txtSpace2);
        tvTime = findViewById(R.id.txtChooseTime);
        tpTime = findViewById(R.id.tpChooseTime);
        btnTime= findViewById(R.id.btnDisplayTime);

        tvEmpty3 = findViewById(R.id.txtSpace3);

        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnConfirmReservation);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get day, month and year from datePicker
                int day = dpDate.getDayOfMonth();
                int month = dpDate.getMonth() + 1;
                int year = dpDate.getYear();

                //form the date(string), dd/mm/yyyy
                String date = "";
                date = "Date is " + day + "/" + month + "/" + year;

                //set the date(string) on the textview (setText)

                tvShowDate.setText(date);


            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1 get hour and minute from time picker
                int hour = tpTime.getCurrentHour();
                int minute = tpTime.getCurrentMinute();

                // 2 to form the time (String), hour:minute
                String time = "";
                time = "Time is " + hour + ":" + minute;

                // 3 to set time (String) on the text view
                tvShowTime.setText(time);


            }
        });

        TimePicker picker=(TimePicker)findViewById(R.id.tpChooseTime);
        picker.setIs24HourView(true);

        if (btnReset.callOnClick()) {
            etName.getText().clear();
            etHpNo.getText().clear();
        } else if (btnSubmit.callOnClick()) {
            Toast.makeText(MainActivity.this, "Name: " + etName.getText() + " Hp No.: " + etHpNo.getText() + " Group Size: " + spNoOfPpl + " Smoking Area: " + tbSmoking.isChecked() + " Date: " + tvShowDate + " Time: " + tvShowTime, Toast.LENGTH_LONG).show();
        }


    }
}