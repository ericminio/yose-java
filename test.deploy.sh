#!/bin/sh
if [ -n "`curl -s https://ericminio-yose-java.herokuapp.com/any`" ]
then
echo "App seems offline :("
exit 0
else
echo "App online :)"
exit 1
fi

