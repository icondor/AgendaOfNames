package ionelcondor;

/**
 * Created by condor on 07/11/15.
 */

import java.util.Scanner;

public class AgendaOfPersons {

    private Person[] nameAgenda = new Person[5];
    private int index;


    public static void main(String[] args) {
        System.out.println("AgendaTa versiunea 2.0");
        AgendaOfPersons m = new AgendaOfPersons();

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

    private String readAString(String label) {
        Scanner s = new Scanner(System.in);
        System.out.print(label);
        String name = s.nextLine();
        return name;
    }

    private int readANumber(String label) {
        Scanner s = new Scanner(System.in);
        System.out.print(label);
        int nr = s.nextInt();
        return nr;
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

        //String val = readName();

        Person val = new Person();

        String name=readAString("Name:");
        String phone = readAString("Phone:");
        int age = readANumber("Age:");

        val.setName(name);
        val.setPhone(phone);
        val.setAge(age);

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
        String oldName = readAString("Nume persoana:");
        for (int i = 0; i < nameAgenda.length; i++) {
            if (nameAgenda[i] != null) { // avoid a nullpointerexception

                Person pcurent=nameAgenda[i];
                String numepcurent=pcurent.getName();

                if (numepcurent.equals(oldName)) {// oldname found
                    System.out.println("Am gasit persoana cu numele, introduceti telefonul nou:");
                    String newPhone = readAString("New Phone:"); // read new name
                    pcurent.setPhone(newPhone); // replace old name with new name
                    isFound=true;
                    System.out.println("Schimbare de telefon efectuata cu succes");
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

                Person p = nameAgenda[i];

                System.out.println(p.getName());
                System.out.println(p.getPhone());
                System.out.println(p.getAge());

                counter++;
            }
        }
        if (counter == 0)
            System.out.println("Agenda este goala");

    }
}