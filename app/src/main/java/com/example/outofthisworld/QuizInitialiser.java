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
            new Questions(R.string.NewtonQ1, "Law of gravitation", "Law of planetary motion", "Law of thermodynamics"),
            new Questions(R.string.NewtonQ2, "Gravity", "Friction", "Electromagnetic Force"),
            new Questions(R.string.NewtonQ3, "Gravity and Inertia", "Weight and Mass", "Force and Motion"),
            new Questions(R.string.NewtonQ4, "Weight", "Pressure", "Mass"),
            new Questions(R.string.StellarQ1, "Angle p-the measure of the distance to a nearby star", "Angle p-the measure of the distance to the sun", "Angle p-the angle of inclination of the earth"),
            new Questions(R.string.StellarQ2, "4.3 light years", "9.8 light years", "12 light years"),
            new Questions(R.string.StellarQ3, "We can look at two different stars from the earth", "We can see a star from two different places on earth", "It does not relate"),
            new Questions(R.string.MilkyQ1, "200-400 billion", "100,000", "600-700 million"),
            new Questions(R.string.MilkyQ2, "Andromeda", "Bode’s galaxy", "Comet Galaxy"),
            new Questions(R.string.MilkyQ3, "Spiral", "Lenticular", "Irregular"),
            new Questions(R.string.MilkyQ4, "Johannes Kepler", "William Herschel", "Simon Marius"),
            new Questions(R.string.ScaleQ1, "300,000km/s", "2 light years", "60,000 au"),
            new Questions(R.string.ScaleQ2, "4.3. light years away", "1 light year away", "6 light years away"),
            new Questions(R.string.ScaleQ3, "Larger than that of Jupiter", "Smaller than that of Jupiter", "About the same as that of Jupiter"),
            new Questions(R.string.ScaleQ4, "1 AU", "50 million km away", "300,000 km away"),
            new Questions(R.string.LifeQ1, "50,000 years", "10,000 years", "60,000 years"),
            new Questions(R.string.LifeQ2, "The product of the number of habitable planets and the probability of life’s origin", "The sum of planets that have water on them", "One. Only our earth"),
            new Questions(R.string.LifeQ3, "All of the given answers", "How they formed and how they evolve", "Whether they are likely to be habitable"),
            new Questions(R.string.LifeQ4, "The study of life in the universe", "The scientific study of the large-scale properties of the universe as a whole", "Neither of the given answers"),




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
                    Intent intent = new Intent(QuizInitialiser.this, QuizEnd.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("incorrect", incorrect);

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
