#!/bin/bash

sum()
{
echo "inside the sum function"
return 10
}

sum
result=$?
echo "result is $result"

echo "---function argument---"

greet1()
{

a=$1
echo "value of a $a"

c=$0
echo "value of c  $c"
echo "----------------"
}

greet1 1
greet1 1 2 3
greet1 1 2 3 4 
