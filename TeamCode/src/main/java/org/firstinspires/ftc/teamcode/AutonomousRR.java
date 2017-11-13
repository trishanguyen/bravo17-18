//Red right
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by rootroot on 11/12/17.
 */

@Autonomous(name="AutoRR")
public class AutonomousRR extends LinearOpMode
{
    Hardware robot = new Hardware();

    public void runOpMode()
    {
        drive( 1, 10 );
    }


    public void drive(double power, int time)
    {
        robot.MotorBL.setPower(power);
        robot.MotorBR.setPower(power);
        robot.MotorFL.setPower(power);
        robot.MotorFR.setPower(power);


        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < time)
        {
        }

        stopDriving();
    }

    public void stopDriving()
    {
        robot.MotorBL.setPower(0);
        robot.MotorBR.setPower(0);
        robot.MotorFL.setPower(0);
        robot.MotorFR.setPower(0);

    }

    @Override
    public synchronized void waitForStart() {
        super.waitForStart();
    }
    
    /*
    public static void omniDrive(double power, byte direction, int time){
        switch (direction) {
            case right:
                MOne.setPower(-power);
                MTwo.setPower(power);
                MThree.setPower(power);
                MFour.setPower(-power);
                break;
            case left:
                MOne.setPower(power);
                MTwo.setPower(-power);
                MThree.setPower(-power);
                MFour.setPower(power);
                break;
            case forward:
                MOne.setPower(power);
                MTwo.setPower(power);
                MThree.setPower(-power);
                MFour.setPower(-power);
                break;
            case backward:
                MOne.setPower(-power);
                MTwo.setPower(-power);
                MThree.setPower(power);
                MFour.setPower(power);
                break;
            case dRF:
                MOne.setPower(0);
                MTwo.setPower(power);
                MThree.setPower(0);
                MFour.setPower(-power);
                break;
            case dRB:
                MOne.setPower(0);
                MTwo.setPower(-power);
                MThree.setPower(0);
                MFour.setPower(power);
                break;
            case dLF:
                MOne.setPower(power);
                MTwo.setPower(0);
                MThree.setPower(-power);
                MFour.setPower(0);
                break;
            case dLB:
                MOne.setPower(-power);
                MTwo.setPower(0);
                MThree.setPower(power);
                MFour.setPower(0);
                break;

            default:return;

        }
        chersTimer(time);
    }

    public static void drive(double power, int time)
    {
        MOne.setPower(power);
        MTwo.setPower(power);
        MThree.setPower(power);
        MFour.setPower(power);

        chersTimer(time);

        stopDriving();
    }

    //for the turn functionS, get rid of time parameter and replace with set time, for 90 degree rotation
    public static void turnLeft(double power, int time)
    {

        MOne.setPower(-power);
        MTwo.setPower(-power);
        MThree.setPower(power);
        MFour.setPower(power);

        chersTimer(time);
        stopDriving();
    }

    public static void turnRight(double power, int time)
    {

        MOne.setPower(power);
        MTwo.setPower(power);
        MThree.setPower(-power);
        MFour.setPower(-power);


        chersTimer(time);
        stopDriving();
    }

    public static void stopDriving()
    {
        drive(0,0);
    }

    public static void chersTimer(int time) {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < time) {
        }
    }
    */
    

}
