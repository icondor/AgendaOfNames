package ionelcondor;

/**
 * Created by condor on 07/11/15.
 */

import java.util.Scanner;


import java.util.Scanner;

public class AgendaOfNames {

    private String[] nameAgenda = new String[50];
    private int index;


    public static void main(String[] args) {
        System.out.println("AgendaTa versiunea 2.0");
        AgendaOfNames m = new AgendaOfNames();

        do {
            m.printMenu(); // afisseaza optiuni
            int option = 0;
            option = m.readMenuOption(); // citste optiunea
            switch (option) {
                case 1:
                    m.listAgenda();
                    break;
                case 2:
                    m.searchAgendaAndDisplay();
                    break;
                case 3:
                    m.createItem();
                    break;
                case 4:
                    m.updateItem();
                    break;
                case 5:
                    m.deleteItem();
                    break;
                case 6:
                    m.daBunaZiua();
                    break;

                case 9:
                    m.exitOption();
                    break;
                default:
                    m.defaultOption();
                    break;
            }
        } while (true);

    }


    private void printMenu() {
        System.out.println("1. List");
        System.out.println("2. Search");
        System.out.println("3. Create");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Da buna ziua");

        System.out.println("9. Exit");
    }

    private void exitOption() {
        System.out.println("Bye, bye...the content not saved will now be erased");
        System.exit(0);
    }

    private void defaultOption() {
        System.out.println("This option does not exist. Pls take another option");
    }

    private String readName() {
        Scanner s = new Scanner(System.in);
        System.out.print("Name: ");
        String name = s.nextLine();
        return name;
    }

    private static int readMenuOption() {
        Scanner s = new Scanner(System.in);
        System.out.print("Option: ");
        int option = s.nextInt();
        return option;
    }


    private void daBunaZiua() {
        System.out.println("buna ziua");
    }

    private void createItem() {
        //daca nu am ajuns la lungime
        // citire
        // adaugare in array

        String val = readName();
        if(index<nameAgenda.length) {
            nameAgenda[index] = val;
            index++;

        }
        else
        {


            //try to find null slots and add th item in the first null slot
            System.out.println("debug: try to find slots");
            for (int i = 0; i < nameAgenda.length; i++) {
                if (nameAgenda[i] == null) { // found one
                    nameAgenda[i] = val;
                    System.out.println("debug: slot found, inserted ok");
                    break;
                }
            }




        }


    }


    private void updateItem() {
        //search and if found do an update
        boolean isFound=false;
        String oldName = readName();
        for (int i = 0; i < nameAgenda.length; i++) {
            if (nameAgenda[i] != null) { // avoid a nullpointerexception
                if (nameAgenda[i].equals(oldName)) {// oldname found
                    System.out.println("Am gasit numele, introduceti noul nume:");
                    String newName = readName(); // read new name
                    nameAgenda[i] = newName; // replace old name with new name
                    isFound=true;
                    System.out.println("Schimbare de nume efectuata cu succes");
                } // end old name found
            }// end compare only the values that are not null
        } // end for interation
        if(!isFound)
            System.out.println("Name not found in the agenda of names");

    } // end method update


    private void deleteItem() {

    }


    /* returns the index where the name was found or -1 if the name is not in the agenda*/
    private int searchAgenda() {
        int index = 0;
        return index;
    }

    /* returns the index where the name was found or -1 if the name is not in the agenda */
    private void searchAgendaAndDisplay() {

    }


    private void listAgenda() {
        System.out.println("aici as lista agenda");
        int counter = 0;
        for (int i = 0; i < nameAgenda.length; i++) {
            if (nameAgenda[i] != null) {
                System.out.println(nameAgenda[i]);
                counter++;
            }
        }
        if (counter == 0)
            System.out.println("Agenda este goala");

    }
}