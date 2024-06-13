#!/bin/bash

read -p "enter the file : " filename

if [ -e $filename ]
then 
echo "file exists"
else
echo "file not exists"
fi
