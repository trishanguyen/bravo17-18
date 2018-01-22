package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

/**
 * Created by ad on 1/19/18.
 */
@TeleOp( name = "elevatorTest", group = "Linear Opmode" )
public class testElevator extends LinearOpMode {
    CRServo rightservo, leftservo;
    @Override
    public void runOpMode(){
        rightservo = hardwareMap.crservo.get("rightservo");
        leftservo = hardwareMap.crservo.get("leftservo");
        waitForStart();

        while (true){
            if(gamepad1.dpad_up){
                rightservo.setPower(1);
                leftservo.setPower(-1);
            } else if (gamepad1.dpad_down){
                rightservo.setPower(-1);
                leftservo.setPower(1);
            } else {
                rightservo.setPower(0);
                leftservo.setPower(0);
            }
        }
    }
}
