/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_control_system;

/**
 * Description: Enumerates the direction the elevator is traveling.
 *              If the elevator is not traveling up or down, then it is 
 *              stationary.
 */
public enum Direction {
    UP, DOWN, STATIONARY;
    
    public String toString(){
        if(this.equals(UP)){
            return("UP");
        }
        if(this.equals(DOWN)){
            return("DOWN");
        }
        return("STATIONARY");
    }
}
