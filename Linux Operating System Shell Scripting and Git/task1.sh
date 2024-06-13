#!/bin/bash

countlines()
{
filename=$1

if [ -e $filename ]
then
echo "file is present"
lines=$(wc -l < "$filename")
words=$(wc -w < "$filename")
echo "number of lines present in the file $filename is $lines"
echo "words are : $words"
else
echo "no file is present"
fi

}

countlines "variable.sh"
countlines "largest.sh"
