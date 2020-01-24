package com.josh.citizenshipquizprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_independence_rights, false),
            new Question(R.string.question_religion, false),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, false),
            new Question(R.string.question_we_people, true),
            new Question(R.string.question_amend, true),
            new Question(R.string.question_bill_of, false),
            new Question(R.string.question_first, false),
            new Question(R.string.question_france, false),
            new Question(R.string.question_market, true),
            new Question(R.string.question_checks, true),
            new Question(R.string.question_in_charge, false),
            new Question(R.string.question_two_parts, true),
            new Question(R.string.question_senate_term, false),
            new Question(R.string.question_number_vote, true),
            new Question(R.string.question_rep_elect, true),
            new Question(R.string.question_senator_people, false),
            new Question(R.string.question_number_reps, false),
            new Question(R.string.question_president_term, false),
            new Question(R.string.question_voting, false),
            new Question(R.string.question_power, true),
            new Question(R.string.question_power_next, false),
            new Question(R.string.question_military, true),
            new Question(R.string.question_cabinet, false),
            new Question(R.string.question_highest_court, true),
            new Question(R.string.question_federal_power, true),
            new Question(R.string.question_state_power, false),
            new Question(R.string.question_political_parties, false),
            new Question(R.string.question_jury_duty, true),
            new Question(R.string.question_voting_rights, false),
            new Question(R.string.question_rights_for, true),
            new Question(R.string.question_pledge, true),
            new Question(R.string.question_loyalty, false),


            //and add more!
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.answer_text_view);

        falseButton.setOnClickListener(this); //register buttons to listen to click events
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                //go to next question
//                currentQuestionIndex++;

                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length; //makes
                // sure we never go out of bounds

                updateQuestion();
                break;


        }

    }

    private void updateQuestion() {
        //log test to make sure questions match up
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId,
                Toast.LENGTH_SHORT)
                .show();

    }
}
