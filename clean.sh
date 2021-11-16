#!/bin/bash

#Usage : ./clean ./

rm -f $1*.class
for rep in $(echo "$1*/")
do
    if [ $rep != "$1*/" ]
    then
        eval "$0 $rep"
    fi
done

exit