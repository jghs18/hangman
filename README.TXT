------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: 2 player hangman
PURPOSE OF PROJECT:
VERSION or DATE:1.9.9 
HOW TO START THIS PROJECT:
IMPORTANT NOTICE--> some comment code is to be ignored as it is for extra credit and not complete
AUTHORS: John Ghantous
-------------------------
Pseudocode and Timeline

-----------------------------------------------------------------------
14th **Complete**
1. Prompt player for 1 word
2. Retrieve player 1's word, store to variable.
3. Count the number of characters in player 1's word, store to variable.
4. Create collection of blank spaces (underscores) corresponding to number of characters in
    word. store to variable.
-----------------------------------------------------------------------
15th **Complete**
5. Establish guess count, store to variable
6. Establish 'guessed letter bank', store to variable (starts off empty(
7. Display blank spaces
-----------------------------------------------------------------------
16th-27nd
8. Prompt player 2 for letter
9. Save letter to variable
    A) if letter does not match the any letters in the word, add the guessed list
        i) Display "letter not found, __ guesses remain"
    B) if letter matches one of the letters in the word, replace the blank with the letter.
10. Print out modified blanks with letters and guessed list
-----------------------------------------------------------------------
28th-6th
Comment code and fix bugs

If guess count reaches 0, display game over.
If all blank spaces get replaced by letters, display "congratulations!"
Ask user if they wish to play again (loop).
----------------------------------------------------------------------
