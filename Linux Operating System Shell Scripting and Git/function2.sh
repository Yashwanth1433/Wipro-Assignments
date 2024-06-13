#!/bin/bash

sum()
{
a=$1
b=$2
result=$(($a+$b))
echo "Result : $result"

}

sum 2 3

read -p  "enter 1st parameter" arg1
read -p  "enter 2nd parameter" arg2

sum $arg1 $arg2

