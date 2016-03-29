import java.util.Scanner;//importing the Scanner class from java library for use
import javax.swing.JOptionPane;//importing the JOption class from the java library for use when hiding the hidden word

public class Hangman//class header-->public denotes scope of access
{
    public static void main (String [] args)//method header - public denotes scope of access
    //void means the method doesn't return anything (just runs), main is the name of the method 
    {
        boolean tryagain = true; // declaring primitve variable tryagain and assigning it to the boolean value of true
        while (tryagain == true)//constructing a while loop with condition that the value of the variable tryagain is true
        {
            boolean valid=true;//declaring boolean variable valid, and assginging it to the value false
            boolean cont=true;
            boolean valids=true;
            boolean valid2=false;
            boolean end = false;
            boolean nextstep = false;
            boolean guesscheck = false;
            boolean enter = false;
            boolean enter2 = false;
            String guess = "";//declaring object reference guess as String and assigning it to the value of ""
            String save = "";
            String word = "";
            Scanner read = new Scanner(System.in); //construct scanner object, assign its memory location to newly 
            //declared object reference read
            while (cont == true)
            {
                
                    word = JOptionPane.showInputDialog(null, "Player 1, enter a word:");/*assigning the value of the String referenced by object
                    reference word to whatever is returned by static method showInputDialog with explicit parameters(null, Stringx)*/
                    if (word==null)
                    {
                        System.exit(0);/*invoking static mutator method exit with explicit paramter (0) on System class*/
                        //error handles the cancel button on the JOptionPane
                    }
                    word = word.toLowerCase();/*reassigning the value of the string referenced by word to the String returned by method toLowerCase invoked upon object
                    reference word*/

                
                int characters = word.length();/*declaring primtive variable type int to characters and assigning it to whatever is returned by method length()
                invoked upon object refernce word*/
                String result = "";
                for (int i = 0; i<characters; i++)/*constructing a for loop with by declaring variable i and assigning it to 0, with condition that int i is less
                than the value stored by primitive variable characters, and if so, add 1 to the value stored by primtive variable i*/
                {
                    if (result == "")//conditional statement to check the String referenced by result
                    {
                        result = result + "_";/*reinitialize the value of the String referenced by object refernce result to the sum of the String result and
                        the String "_ "*/
                    }
                    else
                    {
                        result = result + " ".charAt(0) + "_".charAt(0);/*reinitalizes the value of String result to whatever was previously stored by obejct
                        refernce result + the String " " and "_"*/

                    }
                }
                String spaces = result;//declaring object reference spaces and assigning it to the String referenced by result
                System.out.print(result);//invoking println method on object referenced by System.out
                System.out.println("\nStart guessing letters.");//prompt user for guesses, invoking println method on objec referenced by System.out... 
                //Or you can try to guess the word (by entering the code 2402),\n but you only get one shot at that, do or die...
                while (valid2==false)//constructing while loop with conditional statement value of primtive variable valid2 is false
                {
                    int g = 7;//declaring primitive variable g and assigning it to the integer value 7
                    int g7 = 1;//in beta mode

                    while (g>0 && end==false)/*constructing while loop with conditions that the int value stored in g is greater than 0 AND the value stored in
                    primitve variable end is false*/
                    {

                        while (guesscheck==false)
                        {
                            guess = read.nextLine();/*invoking nextLine method on Scanner object referenced by 'read',
                            assigning the String returned by nextLine to the String referenced by guess*/
                            /*if (guess.equalsIgnoreCase("2402") && g>0)
                            {
                            guesscheck=true;
                            end=true;
                            valid2=true;
                            enter=true;
                            enter2=true;
                            cont=false;
                            }*/
                            if (guess.length()>1)/*constructing an if loop with conditional statement: if the iteger value of whatever is returned
                            by method length() invoked upon object refernce guess, is greater than 1*/
                            {
                                System.out.println("You can only guess one letter character. Try again:");
                            }

                            else
                            {
                                guesscheck=true;//reassign the value of primtive type boolean variable guesscheck to be true
                            }
                        }
                        char checking = guess.charAt(0);/*declaring primtive variable checking as the character returned by method charAt with explicit
                        parameter 0*/
                        if (Character.isUpperCase(checking))//constructing if loop 
                        //static method isUpperCase with explicit parameter(checking)
                        {
                            checking = Character.toLowerCase(checking);/*reinitializing the value of primitve variable to whatever is returned by static
                            method toLowerCase()*/
                            guess = Character.toString(checking);
                        }
                        while (valids==false)
                        {

                            if (save.contains(guess.toLowerCase()))/*constructing if loop with conditoinal statement--> invoking mehtod contains with explicit parameters
                            (invoking method toLowerCase on String refernced by guess) on String refernced by save */
                            //checking to see if the user has already guessed that letter, ignoring the case
                            {
                                System.out.println("You have already guessed that letter...\n Try another:");
                                guess = read.nextLine();
                                valids=false;//reassign the value of primtive type boolean variable valids to be false
                            }
                            else
                            {
                                valids=true;//reassign the value of primtive type boolean variable valids to be true
                            }
                        }

                    }
                    while (valids==true)
                    {
                        spaces = result;
                        if (guess.length()>1)
                        {
                            System.out.println("You can only guess one letter. Try again:");
                            guess = read.nextLine();
                            valids=false;//reassign the value of primtive type boolean variable valids to be false
                        }
                        else 
                        {
                            save = save + guess;
                            if (word.contains(guess))
                            {
                                for(int counter=0; counter<=word.length()-1; counter++)/*creating for loop, assigning the value of primitive variale counter to be 0
                                conditional statement if the integer value stored by counter is less than or equal to the integer value of whatever is returned
                                by method length-1 invoked upon object reference word, with step to add 1 to the value of the integer stored by counter*/
                                {
                                    char character = word.charAt(counter);/*declaring primitve variable character to the character returned by method charAt
                                    invokde upon word with explicit parameter (counter)*/
                                    if (character==guess.charAt(0))
                                    {
                                        String before = result.substring(0,counter*2);
                                        String after = result.substring(counter*2+1);
                                        result = before + guess + after;
                                    }
                                }
                                String result2 = result.replaceAll("\\s+","");/*declaring String result2 as the String returned by the method replaceAll
                                with explicit parameters ("\\s+","")invoked upon object reference result*/
                                //deletes all the spaces in the word to be able to compare it to the word to be guessed
                                if (result2.equalsIgnoreCase(word))/*constructing if statement with conditional statement if the String referenced by result2
                                equalls the String referenced by word ignoring the case differences*/
                                {
                                    System.out.println(result);
                                    System.out.println("Congrats! You have guessed the word!\n The word was: "+word);
                                    valid2=true;//reassign the value of primtive type boolean variable valid2 to be true
                                    cont=false;//reassign the value of primtive type boolean variable cont to be false
                                    end=true;//reassign the value of primtive type boolean variable end to be true
                                }
                                if (valid2==false && cont==true)
                                {
                                    System.out.println(result);
                                    System.out.println("You have " + g + " guesses left.");
                                    System.out.println("You have guessed: " + save);
                                    System.out.println("Keep on guessing!");
                                }                         
                            }
                            else 
                            {
                                if (spaces == result)
                                {
                                    g--;//subtract one from the integer value stored by primitve variable g
                                }
                                if (g == 0)
                                {
                                    System.out.println("You have run out of guesses\n The word was: " + word);
                                    valid2=true;//reassign the value of primtive type boolean variable valid2 to be true
                                    cont=false;//reassign the value of primtive type boolean variable cont to be false
                                }
                                else
                                {
                                    System.out.println(result);
                                    System.out.println("You have " + g + " guesses left.");
                                    System.out.println("You have guessed: " + save);
                                    System.out.println("Keep on guessing!");
                                }
                            }
                            valids=false;//reassign the value of primtive type boolean variable valids to be false
                            guesscheck=false;//reassign the value of primtive type boolean variable guesscheck to be false
                        }
                    }
                }
            }

            System.out.println("Would you like to try again? (y or n)");
            /*while (enter==true)
            {
            System.out.println("You have entered the do or die mode...\n If you would like to cancel enter 'n' otherwise enter 'y'");
            String response2 = read.nextLine();
            while (enter2 ==true)
            {
            if(response2.equalsIgnoreCase("n")) /*constructing if loop wtih condition the user response is equal toString "n" ignoring case
            differnces
            {
            guesscheck = false;
            end = false;
            }
            else if(response2.equalsIgnoreCase("y"))//else if constructs a loop if the one above it is not fulfilled and has its own conditional statement
            {
            System.out.println("Guess the word");
            String response3 = read.nextLine();
            if (response3.equalsIgnoreCase(word))
            {
            System.out.println("Congrats! You have guessed the word!\n The word was: "+word);
            valid2=true;//reassign the value of primtive type boolean variable valid2 to be true
            cont=false;//reassign the value of primtive type boolean variable cont to be false
            end=true;//reassign the value of primtive type boolean variable end to be true
            enter2=false;
            }
            else
            {
            System.out.println("You got it wrong..sorry\n The word was"+word);
            enter2=false;
            }
            }
            else
            {
            System.out.println("Dude either 'y' or 'n'... get it right\n Try again:");
            enter2 = false;//reassign the value of primtive type boolean variable nextstep to be false
            }
            }*/

            while (nextstep==false)
            {
                String response = read.nextLine();
                if(response.equalsIgnoreCase("n")) /*constructing if loop wtih condition the user response is equal toString "n" ignoring case
                differnces*/
                {
                    cont = false;//reassign the value of primtive type boolean variable cont to be false
                    tryagain = false;//reassign the value of primtive type boolean variable tryagain to be false
                    nextstep = true;//reassign the value of primtive type boolean variable nextstep to be true
                    enter2=false;
                }
                else if(response.equalsIgnoreCase("y"))//else if constructs a loop if the one above it is not fulfilled and has its own conditional statement
                {
                    valid = false;//reassign the value of primtive type boolean variable valid to be false
                    nextstep = true;//reassign the value of primtive type boolean variable nextstep to be true
                    enter2=false;
                }
                else
                {
                    System.out.println("Dude either 'y' or 'n'... get it right\n Try again:");
                    nextstep = false;//reassign the value of primtive type boolean variable nextstep to be false
                }
            }
        }
    }
}

