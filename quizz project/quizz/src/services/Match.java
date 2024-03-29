package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Question;
import entities.enums.StudyField;

public class Match {
  
  private List<Question> questions;
  private List<String> playerAnswers;
  private Scanner scanner = new Scanner(System.in);

  public Match(int numberOfQuestions){
    questions = new ArrayList<>();
    playerAnswers = new ArrayList<>();
    setQuestions(numberOfQuestions);
  }

  // user
  public void setQuestions(int numberOfQuestions){

    for(int i=0; i<numberOfQuestions; i++){
      System.out.println("What is the study field of this question? ");
      System.out.println("1 - math , 2 - pyhs, 3 - chem , 4 - prog");
      System.out.print("Number Field: ");

      Question question = null;
      switch ( scanner.nextInt() ){
        case 1 : 
          scanner.nextLine();
          question =  new Question( StudyField.MATHEMATICS ) ;
          break;
        case 2 :
          scanner.nextLine();
          question = new Question( StudyField.PHYSICS) ;
          break;
        case 3:
          scanner.nextLine();
          question = new Question( StudyField.CHEMISTRY );
          break;
        case 4:
          scanner.nextLine();
          question = new Question( StudyField.PROGRAMMING );
          break;
      }

      System.out.println(question);
      questions.add( question );

    }
  }

  // player
  public void play(){

    System.out.println("-------------------------------");

    for(Question question : questions){
      System.out.println(question);
      System.out.print("What is your answer? ");
      playerAnswers.add( scanner.nextLine() );
      System.out.println("-------------------------------");
    }

  }

  // player
  public int scoreResult(){

    int score = 0;
  
    for(int i=0; i<questions.size(); i++){

      if( questions.get(i)
            .getCorrectOption()
            .equalsIgnoreCase(playerAnswers.get(i)) ){
              score++;
            }

    }

    return score;
  }

}
