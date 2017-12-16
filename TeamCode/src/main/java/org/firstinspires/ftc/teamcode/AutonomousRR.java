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
        robot.toggleColorSensorArm();

        if(robot.detectColor().equals("red")){
            robot.omniDrive(.2,Hardware.right,100);
        } else if (robot.detectColor().equals("blue")){
            robot.omniDrive(.2,Hardware.left,100);
        } else if (robot.detectColor().equals("Color not found")){

        }
        robot.omniDrive(.5, Hardware.backward, 1300);
        robot.omniDrive(.25, Hardware.left,300);


    }


}
