package com.netcom.hashmapandsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText name,sub,std,board;
    String stu_name,stu_sub,stu_std,stu_board;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        sub = findViewById(R.id.subject);
        std = findViewById(R.id.standard);
        board = findViewById(R.id.board);
        SharedPreferences settings = getSharedPreferences("user_name", MODE_PRIVATE);
        String studentname = settings.getString("student_name","");
        String studentsubject = settings.getString("student_subject","");
        String studentstandard = settings.getString("student_standard","");
        String studentboard = settings.getString("student_board","");
         if(studentname!=null && !studentname.equals("") && studentsubject!=null && !studentsubject.equals("") && studentstandard!=null && !studentstandard.equals("") && studentboard!=null && !studentboard.equals("")){
             Intent i =new Intent(MainActivity.this,SecondActivity.class);
             i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
             startActivity(i);
             MainActivity.this.finish();
         }
        btn = findViewById(R.id.submit_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu_name = name.getText().toString();
                stu_sub = sub.getText().toString();
                stu_std = std.getText().toString();
                stu_board = board.getText().toString();
                if(stu_name!=null && !stu_name.equals("") && stu_sub!=null && !stu_sub.equals("") && stu_std!=null && !stu_std.equals("") && stu_board!=null && !stu_board.equals("") ){
                    HashMap<String, String> school = new HashMap<>();
                    school.put("student_name",stu_name);
                    school.put("student_subject",stu_sub);
                    school.put("student_standard",stu_std);
                    school.put("student_board",stu_board);
                    String student_name =school.get("student_name");
                    String student_sub =school.get("student_subject");
                    String student_std =school.get("student_standard");
                    String student_board =school.get("student_board");
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("student_name",student_name);
                    editor.putString("student_subject",student_sub);
                    editor.putString("student_standard",student_std);
                    editor.putString("student_board",student_board);
                    editor.apply();
                    Intent h = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(h);
                    MainActivity.this.finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter ur complete detail",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}