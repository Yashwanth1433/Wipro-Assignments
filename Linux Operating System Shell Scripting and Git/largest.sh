#!/bin/bash

read -p "enter the num 1" num1
read -p "enter the num 2" num2
read -p "enter the num 3" num3

if(( $num1 > $num2 & $num1 > $num3 ))
then
echo "num 1 is greater"
elif(( $num2 > $num1 & $num2 > $num3 ))
then
echo "num2 is greater"
else
echo "num3 is greater"
fi

echo "thanks" 
