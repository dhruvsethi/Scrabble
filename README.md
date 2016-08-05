# Scrabble
To find the word with the highest score.

Structure
Subset() function returns an array of strings which essentially is every possible subset of the 7 letter word. 
This array is input onto the Anagram function which returns a list of list of all the anagrams.
The testfor validity() function takes in the list of list and checks it across the dictionary and returns a list of all the valid words.
Computescore() will assign each character with it’s value and returns  a hash map with word as the key and score as the value.
FindHighest() will find the word with the highest count.
