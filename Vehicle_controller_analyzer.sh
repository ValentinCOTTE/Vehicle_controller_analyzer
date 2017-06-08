#!/bin/sh
echo Settings...
java -jar VerifCar_maker.jar
rm Tests.txt
./tmp_script.sh
exit 0
