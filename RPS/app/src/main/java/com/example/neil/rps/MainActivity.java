package com.example.neil.rps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bRock, bPaper, bScissors;
    TextView Score;
    ImageView Human, Comp;
    int humanscore ,computerscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRock = (Button) findViewById(R.id.btnRock);
        bPaper = (Button) findViewById(R.id.btnPaper);
        bScissors = (Button) findViewById(R.id.btnScissors);

        Score = (TextView) findViewById(R.id.txtScore);

        Human = (ImageView) findViewById(R.id.idHumanChoice);
        Comp = (ImageView) findViewById(R.id.idComputerChoice);

        bRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Human.setImageResource(R.drawable.rockpic);
                String message = playturn("rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                Score.setText("Human : " + Integer.toString(humanscore) + "Computer : " + Integer.toString(computerscore));


            }
        });

        bPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Human.setImageResource(R.drawable.paperpic);
                String message= playturn("paper");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                Score.setText("Human : " + Integer.toString(humanscore) + "Computer : " + Integer.toString(computerscore));

            }
        });

        bScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Human.setImageResource(R.drawable.scissorspic);
                String message = playturn("scissors");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                Score.setText("Human : " + Integer.toString(humanscore) + "Computer : " + Integer.toString(computerscore));

            }
        });
    }

        public String playturn (String player_choice)
    {
        String computer_choice = "";
        Random r = new Random();

        int computerchoiceint = r.nextInt(3)+1;

        if(computerchoiceint == 1)
        {
            computer_choice="rock";
        }
        else if (computerchoiceint == 2)
        {
            computer_choice = "paper";
        }
        else if (computerchoiceint == 3)
        {
            computer_choice = "scissors";
        }

        if(computer_choice=="rock")
        {
            Comp.setImageResource(R.drawable.rockpic);
        }
        else if (computer_choice == "paper")
        {
            Comp.setImageResource(R.drawable.paperpic);
        }
        else if (computer_choice == "scissors")
        {
            Comp.setImageResource(R.drawable.scissorspic);
        }

        if(computer_choice == player_choice)
        {
            return "Draw";
        }
        else if (player_choice == "rock" && computer_choice =="scissors")
        {
            humanscore++;
            return "Rock crushes scissors.  YOU WIN!";
        }
        else if (player_choice == "rock" && computer_choice =="paper")
        {
            computerscore++;
            return "Paper covers rock! YOU LOSE!";
        }
        else if (player_choice == "paper" && computer_choice =="rock")
        {
            humanscore++;
            return "paper covers rock.  YOU WIN!";
        }
        else if (player_choice == "paper" && computer_choice =="scissors")
        {
            computerscore++;
            return "scissors cut paper.  YOU LOSE";
        }
        else if (player_choice == "scissors" && computer_choice =="rock")
        {
            computerscore++;
            return "rock smashes scissors.YOU LOSE!";
        }
        else if (player_choice == "scissors" && computer_choice =="paper")
        {
            humanscore++;
            return "scissors cut paper. YOU WIN";
        } else return "ERROR";
    }

}


