#!/bin/bash

display()
{
 path=$1
 if [ -d $path ]
 then
  echo  "correct path $directory"
  else
        "wrong path found"
  fi
}

display "/home/rps/"
