//Red Right
//INCOMPLETE FIX VALUES
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import static java.lang.System.currentTimeMillis;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutoRR" )
public class AutonomousRR extends HardwareSad
{
    public Servo armL,armR,armLUpper,armRUpper,jewelArm;
    long time;
    @Override
    public void runOpMode()
    {
        armL = hardwareMap.servo.get("armL");
        armR = hardwareMap.servo.get("armR");
        init(hardwareMap);
        waitForStart();
        armR.setPosition(.28);
        armL.setPosition(.70);
        ColorSensor color = hardwareMap.colorSensor.get("colorSensor");
        jewelArm  = hardwareMap.servo.get("jewel");
        jewelArm.setPosition(.1);

        chersTimer(2000);
        if ( color.red() > color.blue()) //hits the blue if red is bigger
        {
            sadDrive(.3,Hardware.forward,200);
        }
        else
        {
            sadDrive(.3,Hardware.backward,200);
        }
        jewelArm.setPosition(.8);
        chersTimer(500);
        sadDrive(.5,Hardware.backward,2500);
    }
}
