//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous( name = "AutoRR" )
public class AutonomousRR extends LinearOpMode
{
    long time;
    Hardware robot = new Hardware();
    double DRIVE_POWER = 1.0;
    private ElapsedTime period  = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        robot.omniDrive(.5, Hardware.backward);
        time = System.currentTimeMillis();
        while (System.currentTimeMillis() < time + 1300) ;
        robot.omniDrive(.25, Hardware.left);
        time = System.currentTimeMillis();
        while (System.currentTimeMillis() < time + 300) ;
        robot.omniDrive(0, Hardware.forward);

    }


}
