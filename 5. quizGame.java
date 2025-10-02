import java.util.Scanner;

public class quizGame {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

//        Question Array []
        String[] question1 = {"Siapa presiden indo 2025", "nama planet kita", "Hidup ...."};

//        Options array [][]
        String[][] options = {
                                {"A. Jokowi", "B. Bowok", "C. anis", "D. Ganjar"},
                                {"A. Bekasi","B. Earth","C. Saturnus","D. Mars"},
                                {"A. Jokowi", "B. lonet", "C. Mahasiswa", "D. Rakyat"}
                             };
//        Declare variables
        String[] answers = {"b", "b", "a"};
        int score = 0;
        String guess;
//        Welcome messages
        System.out.println("****************");
        System.out.println("Welcome to quiz");
        System.out.println("****************");

//        question (loop)
        for(int i =0; i < question1.length; i++){
            System.out.println( (i+1) +". " +question1[i]);
            for (String option: options[i]){
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            guess = in.nextLine();
            if(answers[i].equalsIgnoreCase(guess)){
                System.out.println("****************");
                System.out.println("Correct!");
                System.out.println("****************");
                score++;
            }else{
                System.out.println("****************");
                System.out.println("Wrong!");
                System.out.println("****************");

            }
        }
        System.out.println("Your score is: " +score+" of "+ question1.length);


    }
}
