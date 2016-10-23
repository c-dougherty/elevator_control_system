/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_control_system;

/**
 * Description: A floor request made by an elevator user.
 * Properties:  number - the floor number
 *              priorityWeight - weight of request
 *              userId - the user who made the request
 */
public class FloorRequest {
    private int number;
    private int priorityWeight;
    private int userId;

    public FloorRequest(int number, int priorityWeight, int userId) {
        this.number = number;
        this.priorityWeight = priorityWeight;
        this.userId = userId;
    }

    public int getNumber() {
        return number;
    }

    public int getPriorityWeight() {
        return priorityWeight;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setPriorityWeight(int priorityWeight) {
        this.priorityWeight = priorityWeight;
    }
    
}
