package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import static java.lang.Math.abs;


@TeleOp( name = "Teleop", group = "Linear Opmode" )
public class Teleop extends LinearOpMode {

    Hardware robot = new Hardware();

    double power = 1;
    int direction = 0;
    boolean bReleased = true;
    boolean xReleased = true;
    @Override
    public void runOpMode() throws InterruptedException
    {



    robot.init(hardwareMap);
        waitForStart();

        while( opModeIsActive() )
        {
            /*
            Controls:
            Use the right stick to make the robot move left or right
            Use the left stick to make the robot move forwards and backwards
            Use both together to make the robot move diagonally
            Use the a button to operate the grabbing mechanism
            Use the triggers to make the robot turn clockwise or counter clockwise
             */
            if(gamepad1.right_stick_x > 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dLF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y < 0) {
                direction = Hardware.dLB;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRB;
            } else if (gamepad1.right_stick_x > 0) {
                direction = Hardware.right;
            } else if (gamepad1.right_stick_x < 0) {
                direction = Hardware.left;
            } else if (gamepad1.left_stick_y > 0) {
                direction = Hardware.forward;
            } else if (gamepad1.left_stick_y < 0){
                direction = Hardware.backward;
            } else if ( gamepad1.left_trigger > 0.1){
                direction = Hardware.turnC;
                power = gamepad1.left_trigger;
            } else if ( gamepad1.right_trigger > 0.1){
                direction = Hardware.turnCC;
                power = gamepad1.right_trigger;
            } else {
                direction = 0;
            }
            if (gamepad1.a && xReleased){
                robot.closeGripper();
                xReleased = false;
            }
            if (!gamepad1.a){
                xReleased = true;
            }



            //robot.elevator(gamepad2.right_stick_y);
            if (abs(gamepad1.left_stick_y) > 1 && abs(gamepad1.right_stick_x) > 1){
                power = (gamepad1.left_stick_y + gamepad1.right_stick_x)/2;
            }else if (abs(gamepad1.left_stick_y) > 1){
                power = gamepad1.left_stick_y;
            } else if (abs(gamepad1.right_stick_x) > 1){
                power = gamepad1.right_stick_x;
            }
            robot.omniDrive(power,direction);

//            motorFL.setPower( gamepad1.left_stick_y );
//            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }
    }
}

