/*
 * 
 */
package elevator_control_system;

import static java.lang.Math.abs;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: An elevator that services floor requests.
 * Properties:  id - the identification number of the elevator
 *              currFloor - the current location of the elevator
 *              direction - the direction the elevator is going
 *              requests -  priority queue of user requests to service
 */
public class Elevator {
    private int id;
    private int currFloor;
    private Direction direction;
    private Comparator<FloorRequest> floorComp = new FloorComparator();
    private PriorityQueue<FloorRequest> requests = new PriorityQueue<FloorRequest>(10, floorComp);

    public Elevator(int id, int currFloor) {
        this.id = id;
        this.currFloor = currFloor;
        this.direction = Direction.STATIONARY;
    }
    
    // userId - user identifier
    // floor - requested floor to stop at
    // addRequest: adds a users request to the elevator priority queue
    public void addRequest(int userId, int floor){
        
        // print out request info
        System.out.printf("User %d gets on elevator %d, at floor %d, and is"
                + "heading %s to floor %d.\n", userId, id, currFloor, direction.toString(), floor);
        
        // determine priority (distance based)
        int dist = abs(currFloor - floor);
        
        // create request
        FloorRequest req = new FloorRequest(floor, dist, userId);
        
        // add request to queue
        requests.add(req);
        
        // update weights
        for(FloorRequest floorReq: requests){
            floorReq.setPriorityWeight(abs(currFloor - floorReq.getNumber()));
        }
    }
    
    // returns current floor location of elevator
    // update: processes next request and updates elevator info.
    public int update(){
        
        // check for request
        if(requests.peek().equals(null)){
            direction = Direction.STATIONARY;
            System.out.printf("Elevator %d is %s.\n", id, direction.toString());
            return(currFloor);
        } else{
            
            // update floor
            currFloor = requests.peek().getNumber();
            
            // unload passengers
            for(FloorRequest floorReq: requests){
                if(floorReq.getNumber() == currFloor){
                    requests.remove(floorReq);
                    System.out.printf("User %d gets off elevator %d, at floor %d.\n", 
                            floorReq.getUserId(), id, currFloor);
                }
            }
            
            // update direction
            int nextFloor = requests.peek().getNumber();
            if(nextFloor > currFloor){
                direction = Direction.UP;
            } else if(nextFloor < currFloor){
                direction = Direction.DOWN;
            } else{
                direction = Direction.STATIONARY;
            }
            System.out.printf("Elevator %d is going $s.\n", id, direction.toString());

            return(currFloor);
        }
    }
    
    public int getId() {
        return id;
    }

    public int getCurrFloor() {
        return currFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCurrFloor(int currFloor) {
        this.currFloor = currFloor;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}