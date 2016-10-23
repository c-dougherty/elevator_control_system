/*
 * The Elevator Control System handles multiple elevators and user requests.
 * 
 */
package elevator_control_system;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Oct 23, 2016
 * @author Connor Dougherty
 */
public class Elevator_Control_System {
    
    public static final int NUM_ELEVATORS = 4;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create elevators
        List<Elevator> elevatorSys = new ArrayList<Elevator>();
        for(int i = 0; i < NUM_ELEVATORS; i++){
            Elevator elevator = new Elevator(i,0);
            elevatorSys.add(elevator);
            System.out.printf("Elevator %d at floor.\n", 
                    elevator.getId(), elevator.getCurrFloor());
        }
        
        
    }
    
}
