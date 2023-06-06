# Flight-scheduler

* The subject of the project is to create a lightweight flight planner that computes the least priced trip between two cities in a given period of time.
* The input is the set of flights between various cities. It is given as a file. Each line of the file contains `City1 | City2 | Departure-time | Arrival-time | Flight-no. | Price`which means that there is a flight called "flight-no" (which is a string of the form XY012) from city1 to city2 which leaves city1 at time "departure-time" and arrives city2 at time "arrival-time". 
* Further the price of this flight is "price" which is a poitive integer. All times are represented as a string of 4 digits in the 24hr format e.g. 1135, 0245, 2210. 
* I have assumed that all city names are integers between 1 and a number N (where N is the total number of cities). There could be multiple flights between two cities (at different times). 
* A customer can make an enquiry as follows: given two cities "A" and "B", times "t1", "t2", where t1 < t2, find the cheapest trip which leaves city "A" after time "t1" and arrives at city "B" before time "t2". A trip is a sequence of flights which starts at A after time t1 and ends at B before time t2.  
* Further, the departure time from any transit (intermediate) city C is at least 30 mins after the arrival at C. If there are no such flights, it conveys such to the customer.
