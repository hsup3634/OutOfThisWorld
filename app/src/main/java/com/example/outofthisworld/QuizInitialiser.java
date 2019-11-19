package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuizInitialiser extends AppCompatActivity {

    Button button_next;
    TextView question_text;

    int questionCurrent = 0;

    RadioGroup quizRadioGroup;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;

    Questions[] quizQuestions = new Questions[] {
            new Questions(R.string.BasicsQ1, "Copernicus", "Ptolemy", "Kepler"),
            new Questions(R.string.BasicsQ2, "The law of orbits", "The law of periods", "The law of gravity"),
            new Questions(R.string.BasicsQ3, "Ellipses", "Perfect circles", "Triangles"),
            new Questions(R.string.BasicsQ4, "More time", "Less time", "The same amount of time"),
          //  new Questions("5. "),
            //new Questions("6. ")

    };

    ArrayList<Questions> correct = new ArrayList<>();
    ArrayList<Questions> incorrect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_page);

        Intent intent4 = getIntent();

        button_next = findViewById(R.id.button_next);
        question_text = findViewById(R.id.question_text);
        quizRadioGroup = findViewById(R.id.quizRadioGroup);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        repeatQuestions();

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(quizQuestions[questionCurrent]);
                if(questionCurrent == (quizQuestions.length - 1)) {

                    //TODO change contentdetailactivity to results class
                    Intent intent = new Intent(QuizInitialiser.this, ContentDetailActivity.class);
                    intent.putExtra("CORRECT!", correct);
                    intent.putExtra("INCORRECT!", incorrect);

                    startActivity(intent);

                } else{
                    questionCurrent++;
                    repeatQuestions();
                    button_next.setVisibility(View.INVISIBLE);
                }
            }
        });

        quizRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedAnswer = group.findViewById(checkedId);
                button_next.setVisibility(View.VISIBLE);

            }
        });

    }

    public void repeatQuestions() {
        button_next.setVisibility(View.INVISIBLE);
        quizRadioGroup.clearCheck();
        question_text.setText(quizQuestions[questionCurrent].getId());
       // fixVisible(quizQuestions[questionCurrent]);
        fixQVisible(quizQuestions[questionCurrent]);
        assignRadioAnswers(quizQuestions[questionCurrent]);
    }

    public void fixQVisible(Questions questions) {
        answer1.setVisibility(View.VISIBLE);
        answer2.setVisibility(View.VISIBLE);
        answer3.setVisibility(View.VISIBLE);

    }

    public void assignRadioAnswers(Questions questions) {
        ArrayList<String> questionOps = new ArrayList<>(Arrays.asList(
           questions.getAns(),
           questions.getInc1(),
           questions.getInc2()
        ));

        int numberRandom = Math.abs(new Random().nextInt(3));
        answer1.setText(questionOps.get(numberRandom));
        questionOps.remove(numberRandom);

        numberRandom = Math.abs(new Random().nextInt(2));
        answer2.setText(questionOps.get(numberRandom));
        questionOps.remove(numberRandom);

       // numberRandom = Math.abs(new Random().nextInt(0));
        answer3.setText(questionOps.get(0));
        //questionOps.remove(numberRandom);


    }

    public void checkAnswer(Questions questions) {
        String ans;
        String correctAns = questions.getAns();

        int msgId = 0;
        ans = whichClicked();
        if (ans.equals(correctAns)) {
            correct.add(quizQuestions[questionCurrent]);
            msgId = R.string.correcto;

        } else {
            incorrect.add(quizQuestions[questionCurrent]);
            msgId = R.string.incorrecto;

        }

        Toast.makeText(this, msgId, Toast.LENGTH_SHORT).show();
    }


    public RadioButton correctRadioAns (String correct) {
        if(answer1.getText() == correct) {
            return answer1;
        } else if (answer3.getText() == correct) {
            return answer3;
        } else {
            return answer2;
        }
    }

    public String whichClicked() {
        if (answer1.isChecked())
        return answer1.getText().toString();
        else if (answer2.isChecked())
            return (answer2.getText().toString());
        else return answer3.getText().toString();
    }




}
