package Week05.SimpleDotCom;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               SimpleDotCom                          *
 *************************************************************************/

public class SimpleDotComTestDrive {

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocationCells(locations);
        String userGuess = "4";
        String result = dot.checkYourself(userGuess);

    }
}

                                                                           
