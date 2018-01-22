package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Evelyn on 1/21/2018.
 */

@TeleOp( name = "CRServoTest", group = "Linear Opmode" )
public class CRServoTest extends LinearOpMode
{
    CRServo armR, armL;

    public void runOpMode()
    {
        CRServo armR = hardwareMap.crservo.get("intakeR");
        CRServo armL = hardwareMap.crservo.get("intakeL");
        waitForStart();
        armR.setPower(0.5);
        armL.setPower(0.5);
        while(opModeIsActive()) {
            armR.setPower(1.0);
            armL.setPower(0.0);
        }
    }
}
