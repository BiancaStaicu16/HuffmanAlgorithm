# HuffmanAlgorithm

## Description

Huffman coding was the state of the art in compression in the 1950s and at the time it was considered a breakthrough. 
It’s a greedy algorithm and interesting: The general schematics of a compression algorithm. 
The original data is run through an encoder and a compressed file is generated. 
The compressed data should be smaller than the original data and it includes enough information to allow for the data to be run through a decoder. 
In a lossless algorithm, the decompressed data should be the same as the original data.

## Prerequisites

JAVA 8.0

## Date
Project was finished on 20/03/2021.

## Setup

Unzip the archive. 
Open a command prompt window and go to the directory where you saved the java program (HuffmanCoding.java). 
Assume it's C:. 
Type 'javac HuffmanCoding.java' and press enter to compile your code.
If there are no errors in your code, the command prompt will take you to the next line (Assumption: The path variable is set).
Now, type ' java HuffmanCoding ' to run your program.
You will be able to see the result printed on the window.

## Usage

Data compression is part of almost every activity we do in computer science.
We compress data before transmitting, we compress video files, we compress music files, etc.
Many of the file formats you use such as jpeg, mp3, tiff, mp4, to name a few. 
The principle is quite simple and despite the many ways compression is implemented, the general goal
is to look at repetitions within the data that would allow you to replace a large piece of repeated 
data with a shorter version and hence save space.
That is what my program is trying to achieve. 
This will be useful when it comes to compressing files.

## Contribution

This project was developed by candidate: Bianca Staicu.
