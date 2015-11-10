package ionelcondor;

import java.util.*;

/**
 * Created by condor on 07/11/15.
 */
public class DemoColectii {

    public static void main(String[] arg) {

        String[] listaDeNume = new String[20];
        listaDeNume[0]="ion";

        List lDeNume = new LinkedList<>();
        lDeNume.add("ionel");
        lDeNume.add("maria");


        Set s = new HashSet<>();
        s.add("ion");
        s.add("ion");

        Iterator i = lDeNume.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
