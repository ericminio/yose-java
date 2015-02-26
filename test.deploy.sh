#!/bin/sh
if [ -n "`curl -s https://ericminio-yose-java.herokuapp.com/ping`" ]
then
echo "App online :)"
exit 0
else
echo "App seems offline :("
exit 1
fi

