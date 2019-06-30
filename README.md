# Words-in-Text-Files
Purpose

CS1027: Foundations of Computer Science II Assignment 4


To gain experience with

•   Developing and using a binary tree

•   Using different data structures (arrays, binary trees, linked lists) in one application

1. Introduction

The Ontario Scientific London Library (LL) requires a new program where users can search for words in a large collection C of documents stored in text files. More specifically, a user would like to know the files, and the location in these files, where a particular word exists. For this assignment, you will design and implement a program in Java to be able to efficiently search for words in a collection C of text documents. The collection of words contained in the text documents is called a lexicon.

The program receives as input a file I containing a list of words to search in the lexicon. You will be provided with code that will read the files in collection C and it will store the words contained in these files in a lexicon data structure that holds location information about the different words. This data structure is an array in which every entry stores a binary search tree (binary search trees are described below; also, read the lecture notes on binary search trees). Every node of a binary search tree stores a word w and a list of files where the word appears; for each file the data structure also stores a list of positions within this file where the word w appears. More details of the data structure are given below.

We consider that the same word may be contained in more than one file. Once the program has stored the words in the lexicon data structure, the input file I will be read. Each word in I will be searched in the lexicon and information about the files that contain the word and the positions of the word in the files will be printed. Check assignment outline provided for more info.
