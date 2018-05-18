package com.example.ahmed.mathtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int first_num, second_num, random_op;
    int choice1, choice2, choice3, answer;
    ListView listView_output;
    Button btn_choice1, btn_choice2, btn_choice3;
    TextView txt_question;
    // choice1,choice2,choice3  are Available outputs of first_num ,second_num
    // answer is true output of  first_num ,second_num
    char op_char[] = {'+', '-', '*', '/', '='};
    char op;

    Random random = new Random();
    ArrayList<List_Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_output = (ListView) findViewById(R.id.list_item);
        txt_question = (TextView) findViewById(R.id.txt_question);

        btn_choice1 = (Button) findViewById(R.id.btn_choice1);
        btn_choice1.setOnClickListener(this);

        btn_choice2 = (Button) findViewById(R.id.btn_choice2);
        btn_choice2.setOnClickListener(this);

        btn_choice3 = (Button) findViewById(R.id.btn_choice3);
        btn_choice3.setOnClickListener(this);
        set_values();

    }

    public void set_values() {
        // find random operation
        random_op = random.nextInt(4);
        op = op_char[random_op];

        switch (op) {
            case '+':
                first_num = random.nextInt(100);
                second_num = random.nextInt(100);
                answer = first_num + second_num;
                set_choices();
                break;

            case '*':
                first_num = random.nextInt(13);
                second_num = random.nextInt(13);
                answer = first_num * second_num;
                set_choices();
                break;

            case '-':
                first_num = random.nextInt(200 - 50) + 50;
                second_num = random.nextInt(50);
                answer = first_num - second_num;
                set_choices();
                break;

            case '/':
                first_num = random.nextInt(144);
                second_num = random.nextInt(12 - 1) + 1;
                answer = first_num / second_num;
                set_choices();
                break;
        }
    }

    public void set_choices() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" " + first_num).append(" " + op).append(" " + second_num).append(" " + op_char[4]).append(" ? ");
        txt_question.setText(stringBuffer);

        choice1 = random.nextInt(144);
        choice2 = random.nextInt(144);
        choice3 = random.nextInt(144);

        int x[] = {choice1, choice2, choice3};

        int choice = random.nextInt(3);

        x[choice] = answer;

        btn_choice1.setText("" + x[0]);
        btn_choice2.setText("" + x[1]);
        btn_choice3.setText("" + x[2]);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;

        int check = Integer.parseInt(button.getText().toString());

        if (check == answer) {
            items.add(new List_Item(first_num + " " + op + " " + second_num + " " + op_char[4] + " " + check + "     right"));
            show_result();
            set_values();
        } else {
            items.add(new List_Item(first_num + " " + op + " " + second_num + " " + op_char[4] + " " + check + "     false"));
            show_result();
        }
    }

    public void show_result() {
        MyAdapter adapter = new MyAdapter(items, this);
        listView_output.setAdapter(adapter);
    }


}