package Week02.Tutorial1ClassesAndObjects.Problem2;


import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Problem2                                 *
 *************************************************************************/

public class MainDriver {

    static  Scanner kboard = new Scanner(System.in);

    public static boolean getContinuePromptAnswer() {                                                        //prompts the user if they wish to do a command again
        boolean userAnswer;
        System.out.print("\nDo you want to do another? (Y)es (N)o : ");
        userAnswer = kboard.next().equalsIgnoreCase("y");
        return userAnswer;
    }

    public static void main(String[] args) {
        int menuLoop = 0;
        int answer;
        boolean doFunctionAgain;

        while(menuLoop != 3) {

            System.out.println("Shapes Problem");
            System.out.print("Press [1] For Rectangle, [2] For Circle Or [3] To Exit: ");
            answer = kboard.nextInt();
            switch (answer) {

                case 1:
                    System.out.println("You chose option 1 - Rectangle");
                    Rectangle r = new Rectangle();
                    r.displayInformation();
                    doFunctionAgain = getContinuePromptAnswer();
                    break;

                case 2:
                    System.out.println("You chose option 2 - Circle");
                    Circle c = new Circle();
                    c.displayInformation();
                    doFunctionAgain = getContinuePromptAnswer();
                    break;

                case 3:
                    System.out.println("You chose option 3 - Quit");
                    System.out.println("Goodbye!");
                    menuLoop = 3;
                    break;

                default:
                    System.out.println("Please enter an input of 1, 2 or 3");
            }
        }       kboard.close();


    }
}





