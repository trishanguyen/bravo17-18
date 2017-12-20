//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.System.currentTimeMillis;


@Autonomous( name = "AutoRR" )
public class AutonomousRR extends LinearOpMode
{
    long time;
    Hardware robot = new Hardware();
    double DRIVE_POWER = 1.0;
    private ElapsedTime period  = new ElapsedTime();

    public Servo jewelArm;
    public ColorSensor color;
    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);
        jewelArm  = hardwareMap.servo.get("jewel");

        color = hardwareMap.colorSensor.get("colorSensor");
        waitForStart();

        jewelArm.setPosition(0);

//        if(robot.detectColor().equals("red"))
// {
//            robot.omniDrive(.2,Hardware.right,100);
//        } else if (robot.detectColor().equals("blue"))
// {
//            robot.omniDrive(.2,Hardware.left,100);
//        } else if (robot.detectColor().equals("Color not found")){

//
//        }



//        robot.omniDrive(.5, Hardware.backward, 1300);
//        robot.omniDrive(.25, Hardware.left,300);
        long startTime = currentTimeMillis();

        while (currentTimeMillis() < startTime + 2000) ;
        if ( color.red() < color.blue())
        {
            robot.omniDrive(.3,Hardware.forward,500);
        }
        else
        {
            robot.omniDrive(.3,Hardware.backward,500);
        }
        jewelArm.setPosition(1.2);

//
//        while(opModeIsActive())
//        {
//            telemetry.addData("Red", color.red());
//            telemetry.addData("Green", color.green());
//            telemetry.addData("Blue", color.blue());
//            telemetry.update();
//        }
    }


}
