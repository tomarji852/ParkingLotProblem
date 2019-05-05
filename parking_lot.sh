chmod +x clean.sh
./clean.sh

mkdir bin;

javac src/parkinglot/*.java -d bin/;

java -cp bin parkinglot.ParkingLotManager;
