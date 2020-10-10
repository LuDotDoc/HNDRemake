package Week05.inhertitanceTut.cat;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               inhertitancetut                          *
 *************************************************************************/

import java.io.*;
public class Cat
{
    private String catName;
    private String catBreed;
    private int catAge;
    public Cat(String a, String b, int c)
    {
        getCatDetails(a,b,c);
    }
    public void getCatDetails(String gCatName, String gBreed, int gAge)
    {
        catName=gCatName;
        catBreed = gBreed;
        catAge = gAge;
    }
    public void displayDetails() throws IOException
    {
        System.out.println("Cats name is : "+catName);
        System.out.println("Cats breed is : "+catBreed);
        System.out.println("Cats age is : "+catAge);
    }

}

                                                                           
