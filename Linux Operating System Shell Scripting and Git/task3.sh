#!/bin/bash

evenOdd()
{
num=$1
if (( $nmuber %2 == 0 ))
then
echo "$number is Even"
else
echo "$number is Odd"
fi
}

while true
do
read -p "Enter the number(Press 0 to exit): " number

if [[ $number -eq 0 ]]
then
echo "EXIT DONE!"
break
fi
evenOdd $number
done
