package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.enums.StudyField;

public class Question {
 
  // atributes
  private String question;
  private List<String> options;
  private String correctOption;
  private String correctAnswer;
  private StudyField field;
  
  // cosntructor
  public Question(StudyField field){
    Scanner scanner = new Scanner(System.in);
    options = new ArrayList<>();
    this.field = field;

    System.out.print("Insert your question: ");
    addQuestion( scanner.nextLine() );
    scanner.close();
  }

  public Question(String question, StudyField field){
    this.question = question;
    this.field = field;
    
    options = new ArrayList<>();
    addQuestion();
  }

  // getters and setters
  public String getQuestion() {
    return question;
  }

  public List<String> getOptions() {
    return options;
  }

  public String getCorrectOption() {
    return correctOption;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public StudyField getField() {
    return field;
  }

    
  // methods
  public void addQuestion(){
    addQuestion(question);
  }

  public void addQuestion(String question){ 
    Scanner scanner = new Scanner(System.in);
    this.question = question;
    
    // minimum of 1 option
    addOption();
    String choice;

    do{ 
      System.out.print("do you want to add new option? (y/n) : ");
      choice = scanner.nextLine();

      if(choice.equalsIgnoreCase("n")) break;
      addOption();        
    }while( true );

    System.out.print("Please, insert the correct option: ");
    setCorrect( scanner.nextLine() );
    scanner.close();
  }

  public void addOption(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert a new option: ");
    options.add( scanner.nextLine() );
    scanner.close();
  }

  public void setCorrect(String optionLetter){
    correctOption = optionLetter.toUpperCase();
    int numberOption = Integer.valueOf( optionLetter.toUpperCase().charAt(0) ); // 96
    int equivalentA = Integer.valueOf("A".charAt(0) ); // 95

    numberOption -= equivalentA; // 1

    correctAnswer = options.get(numberOption); // 
  }

  public String toString(){
    String aux = "## Question: " + question + "\n";
    char c = 'A';

    for(int i=0; i<options.size(); i++){
      aux +=  "(" + c + ") " 
              + options.get(i);

      if( i!= options.size() - 1) aux += "\n";
      c++;
    }
    
    return aux;
  }


}