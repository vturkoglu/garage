# Getting Started

### Reference Documentation
In this application, we have a garage that has 10 slots for parking vehicles. (Car,Jeep,Truck)
```
When a car enters the garage, it holds 1 slot. When it leaves, release the slot
When a jeep enter the garage, it holds 2 slots. When it leaves, release the slot
When a truck enter the garage, it holds 4 slots. When it leaves, release the slot
```

The app has 3 controller method;
#### Getting status of Garage
```
GET http://localhost:8080/garage/status
```
#### Parking vehicle into Garage
```
POST http://localhost:8080/garage/park/{vehicle}

Samples:
POST http://localhost:8080/garage/park/34-SO-1988 Black Car
POST http://localhost:8080/garage/park/34-BO-1987 Red Truck
POST http://localhost:8080/garage/park/34-VO-2018 Blue Jeep
POST http://localhost:8080/garage/park/34-LO-2000 White Car
```
#### Leaving from Garage
```
POST http://localhost:8080/garage/leave/{vehicle}

Samples:
POST http://localhost:8080/garage/leave/34-BO-1987 Red Truck
POST http://localhost:8080/garage/leave/34-VO-2018 Blue Jeep
POST http://localhost:8080/garage/leave/34-LO-2000 White Car
```