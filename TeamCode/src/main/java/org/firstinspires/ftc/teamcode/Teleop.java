package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.Math.abs;


@TeleOp( name = "Teleop", group = "Linear Opmode" )
public class Teleop extends HardwareSad {

    private Servo armL,armR,armLUpper,armRUpper,jewelArm;
    private CRServo elevatorRight,elevatorLeft;
    double power = 1;
    int direction = 0;
    private boolean closed=false,closedUpper=false;
    boolean bReleased = true;
    boolean xReleased = true;
    @Override
    public void runOpMode() throws InterruptedException
    {

        armL = hardwareMap.servo.get("armL");
        armR = hardwareMap.servo.get("armR");
        jewelArm = hardwareMap.servo.get("jewel");
//        elevatorRight = hardwareMap.crservo.get("rightservo");
//        elevatorLeft = hardwareMap.crservo.get("leftservo");

//        armLUpper = hardwareMap.servo.get("armLUpper");
//        armRUpper = hardwareMap.servo.get("armRUpper");
        init(hardwareMap);
        waitForStart();

        while( opModeIsActive() )
        {
            jewelArm.setPosition(.8);
            /*
            Controls:
            Use the right stick to make the robot move left or right
            Use the left stick to make the robot move forwards and backwards
            Use both together to make the robot move diagonally
            Use the a button to operate the grabbing mechanism
            Use the triggers to make the robot turn clockwise or counter clockwise
             */
            /*if(gamepad1.right_stick_x > 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dLF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y < 0) {
                direction = Hardware.dLB;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRB;
            } else*/ if (gamepad1.right_stick_x > 0) {
                direction = Hardware.right;
            } else if (gamepad1.right_stick_x < 0) {
                direction = Hardware.left;
            } else if (gamepad1.left_stick_y > 0) {
                direction = Hardware.forward;
            } else if (gamepad1.left_stick_y < 0){
                direction = Hardware.backward;
            } /*else if ( gamepad1.left_trigger > 0.1){
                direction = Hardware.turnC;
                power = gamepad1.left_trigger;
            } else if ( gamepad1.right_trigger > 0.1){
                direction = Hardware.turnCC;
                power = gamepad1.right_trigger;
            }*/ else {
                direction = 0;
            }
            if (gamepad1.dpad_up){
                elevator(1) ;
            } else if (gamepad1.dpad_down) {
                elevator(-1);
            } else {
                elevator(0);
            }
            if (gamepad1.a && xReleased){
                if(closed )
                {
                    armR.setPosition(.28);
                    armL.setPosition(.70);
                    telemetry.addData("Robot", "Closed");
                    telemetry.update();
                    closed = false;
                }

                else
                {
                    armR.setPosition(.56);
                    armL.setPosition(.35);
                    telemetry.addData("Robot", "Open");
                    telemetry.update();
                    closed = true;
                }
                xReleased = false;
            }
            if (!gamepad1.a){
                xReleased = true;
            }

//
//            if (gamepad1.b && bReleased){
//                if(closedUpper )
//                {
//                    armRUpper.setPosition(.28);
//                    armLUpper.setPosition(.70);
//                    telemetry.addData("Robot", "Closed");
//                    telemetry.update();
//                    closedUpper = false;
//                }
//
//                else
//                {
//                    armRUpper.setPosition(.66);
//                    armLUpper.setPosition(.35);
//                    telemetry.addData("Robot", "Open");
//                    telemetry.update();
//                    closedUpper = true;
//                }
//                bReleased = false;
//            }
            if (!gamepad1.b){
                bReleased = true;
            }



            //elevator(gamepad2.right_stick_y);
            if (abs(gamepad1.left_stick_y) > 1 && abs(gamepad1.right_stick_x) > 1){
                power = (gamepad1.left_stick_y + gamepad1.right_stick_x)/2;
            }else if (abs(gamepad1.left_stick_y) > 1){
                power = gamepad1.left_stick_y;
            } else if (abs(gamepad1.right_stick_x) > 1){
                power = gamepad1.right_stick_x;
            }
            if (gamepad1.right_trigger > 0)
            sadDrive(power/2.0,direction);
            else
            sadDrive(power,direction);
//            motorFL.setPower( gamepad1.left_stick_y );
//            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }
    }

}

