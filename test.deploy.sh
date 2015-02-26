#!/bin/sh
if [ -n "`curl -s https://ericminio-yose-java.herokuapp.com/any`" ]
then
exit 0
else
exit 1
fi

