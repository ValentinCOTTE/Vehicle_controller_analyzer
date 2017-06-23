#!/bin/sh
echo "voiture1: init_V=2000  init_A=0        voiture2: init_V=3000  init_A=0" >>Tests.txt
java -jar Generator.jar 100 10 50000 1050 1000 4000 -500 300 100 100 100 500 200 20000 40000 3 350 750 2 11 11 3 3 4 4 5000 0 525 525 2000 3000 0 0 2 0 1 1 50000 1 1 0 1 1 50000 1 1 200 50 1000 100 500
echo Formal verification with queries.q ...
./verifyta -q -s new_VerifCar.xml resources/queries.q >> Tests.txt
echo File Tests.txt done

exit 0
