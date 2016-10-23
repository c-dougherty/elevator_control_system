/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_control_system;

import java.util.Comparator;

/**
 * Description: Compares two floor requests and returns the request with the
 *              lower priority weight.
 */
public class FloorComparator implements Comparator<FloorRequest> {
    
    public int compare(FloorRequest a, FloorRequest b) {
        if(a.getPriorityWeight() < b.getPriorityWeight()){
            return a.getPriorityWeight();
        } else{
            return b.getPriorityWeight();
        }
    }
}
