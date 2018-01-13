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
public class AutonomousRR extends HardwareSad
{
    long time;
    
    double DRIVE_POWER = 1.0;
    private ElapsedTime period  = new ElapsedTime();


//    public ColorSensor color;
    public Servo armL,armR,armLUpper,armRUpper,jewelArm;
    @Override
    public void runOpMode()
    {
        armL = hardwareMap.servo.get("armL");
        armR = hardwareMap.servo.get("armR");
        init();
//        jewelArm  = hardwareMap.servo.get("jewel");

//        color = hardwareMap.colorSensor.get("colorSensor");
        waitForStart();
        armR.setPosition(.28);
        armL.setPosition(.70);

//        jewelArm.setPosition(.5);
//        jewelArm.setPosition(.25);
//        jewelArm.setPosition(0);
//        if(detectColor().equals("red"))
// {
//            omniDrive(.2,Hardware.right,100);
//        } else if (detectColor().equals("blue"))
// {
//            omniDrive(.2,Hardware.left,100);
//        } else if (detectColor().equals("Color not found")){

//
//        }
        sadDrive(.5,Hardware.backward,1300);
        sadDrive(.25,Hardware.left,400);
        sadDrive(1,Hardware.backward,100);
        sadDrive(0,Hardware.forward);



//        omniDrive(.5, Hardware.backward, 1300);
//        omniDrive(.25, Hardware.left,300);
//        long startTime = currentTimeMillis();
//
//        while (currentTimeMillis() < startTime + 2000) ;
        /*if ( color.red() < color.blue() )
        {
            sadDrive(.3,Hardware.forward,500);
        }
        else
        {
            sadDrive(.3,Hardware.backward,500);
        }
        jewelArm.setPosition(1.2);
        sadDrive(.5,Hardware.backward,1300);
        sadDrive(.25,Hardware.right,300);
        sadDrive(.25,Hardware.backward,100);
        sadDrive(0,Hardware.forward);
*/

      /*  while(opModeIsActive())
        {
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());

            telemetry.update();
        }
*/    }


}
