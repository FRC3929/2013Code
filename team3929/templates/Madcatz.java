/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team3929.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A joystick wrapper class for the Rumblepad 2 Gamepad We will be using
 * @author Jeremy Germita
 */
public class Madcatz {

    public Joystick m_Pad;   //Joystick object

    /**
     * Contructor.
     * @param port The USB the gamepad is connected to
     */
    public Madcatz(int port) {
        m_Pad = new Joystick(port);     //Instantiate the gamepad on port 1
    }

    /**
     * Get the left Y axis
     * @return the Y axis
     */
    public double getLeftY() {//get left joystick y value
        return m_Pad.getRawAxis(2);

    }

    /**
     * Get the left X axis
     * @return the X axis
     */
    public double getLeftX() {
        return m_Pad.getRawAxis(1); //Return the left X axis value
    }

    /**
     * Get the left Y axis
     * @return the Y axis
     */
    public double getRightY() {
        return m_Pad.getRawAxis(5); //Return the right Y axis value

    }

    /**
     * Get the right X axis
     * @return the X axis
     */
    public double getRightX() {
        return m_Pad.getRawAxis(4); //Return the right X axis value
    }

    public double getTrigger(){//return z axis, or trigger values
        return m_Pad.getRawAxis(3);
    }

    /**
     * Get the state the button
     * @param button the button to poll
     * @return the state of the button
     */
    public boolean getButton(int button) {
        return m_Pad.getRawButton(button);  //Return the state of the desired button
    }

    /**
     * Get the state of the specified D pad direction
     * @param direction
     * @return
     */
    public boolean getDPad(int direction) {
        switch (direction) {
            case Madcatz.DPadStates.UP:
                return (m_Pad.getRawAxis(6) < -.7);
            case Madcatz.DPadStates.DOWN:
                return (m_Pad.getRawAxis(6) > .7);
            case Madcatz.DPadStates.LEFT:
                return (m_Pad.getRawAxis(5) > .7);
            case Madcatz.DPadStates.RIGHT:
                return (m_Pad.getRawAxis(5) < -.7);
            default:
                return false;

        }
    }

    /**
     * Directional pad states.
     */
    public static interface DPadStates { //gives Dpad values integer numbers for referencing

        final int UP = 0;
        final int DOWN = 1;
        final int LEFT = 2;
        final int RIGHT = 3;
    }

    /**
     * Get the states of all of the buttons on the gamepad
     * @return
     */
    public boolean getAny() { //this can check if any button at all is pushed.. Kindave handy i guess
        return getButton(1) || getButton(2) || getButton(3) || getButton(4) || getButton(5)
                || getButton(6) || getButton(7) || getButton(8) || getButton(9) || getButton(10);
                
    }
}
