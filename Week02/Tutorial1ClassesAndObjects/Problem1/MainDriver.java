package Week02.Tutorial1ClassesAndObjects.Problem1;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *************************************************************************/
public class MainDriver {
    public static void main(String[] args) {

        Person p = new Person();
        Person p2 = new Person("Bob", "Freeman");
        Person p3 = new Person("Chris", "Freeman", 32);

        p.displayPerson();
        p2.displayPerson();
        p3.displayPerson();
    }
}

                                                                           
