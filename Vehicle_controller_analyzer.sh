#!/bin/bash
echo Settings...
java -jar VerifCar_maker.jar
echo Formal verification with queries.q ...
./verifyta -q -s new_VerifCar.xml resources/queries.q > Tests.txt
echo File Tests.txt done
exit 0
