package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by ad on 12/12/17.
 */
@Autonomous( name = "test" )
public class test extends LinearOpMode {
    Hardware robot = new Hardware();
    public void runOpMode(){
        robot.init(hardwareMap);
        robot.jewelArm.setPosition(.5);
    }
}
