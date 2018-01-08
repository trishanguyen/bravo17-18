package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.hitechnic.HiTechnicNxtColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import static java.lang.System.currentTimeMillis;

public abstract class Hardware extends LinearOpMode
{
    //public HiTechnicNxtColorSensor colorSensor;
    public ColorSensor color;

    public DcMotor MotorFL, MotorBL, MotorFR, MotorBR, ElevatorMotor;
    public Servo armL,armR,armLUpper,armRUpper,jewelArm;
   // private CRServo elevator;
    public static final int right = 1;
    public static final int left = 2;
    public static final int forward = 3;
    public static final int backward = 4;
    // Diagonal Right Forward
    public static final int dRF = 5;
    // Diagonal Right Backward
    public static final int dRB = 6;
    // Diagonal Left Forward
    public static final int dLF = 7;
    // Diagonal Left Backward
    public static final int dLB = 8;
    public static final int turnC = 9;
    public static final int turnCC = 10;
    private boolean closed = true,closedUpper = true, jewelArmDown = true;
    private double startTime = getRuntime();

    HardwareMap   hwMap =  null;

    @Override
    public void runOpMode() throws InterruptedException
    {
    }


    public static void chersTimer(int millis){
        long startTime = currentTimeMillis();
        while (currentTimeMillis() < startTime + millis) ;
    }
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap)
    {
        try
        {
            hwMap = ahwMap;
            //colorSensor = hwMap.colorSensor.get("color");
            MotorFL = hwMap.dcMotor.get("flmotor");
            MotorBL = hwMap.dcMotor.get("blmotor");
            MotorFR = hwMap.dcMotor.get("frmotor");
            MotorBR = hwMap.dcMotor.get("brmotor");
            ElevatorMotor = hwMap.dcMotor.get("elevatormotor");
            armL = hwMap.servo.get("armL");
            armR = hwMap.servo.get("armR");
            armLUpper = hwMap.servo.get("armLUpper");
            armRUpper = hwMap.servo.get("armRUpper");
            color = hwMap.colorSensor.get("color");
            //elevator = hwMap.crservo.get("elevator");
            jewelArm = hardwareMap.servo.get("jewel");
           // colorSensor = hwMap.colorSensor.get("colorSensor");

            MotorFL.setDirection(DcMotor.Direction.FORWARD);
            MotorBL.setDirection(DcMotor.Direction.FORWARD);
            MotorFR.setDirection(DcMotor.Direction.FORWARD);
            MotorBR.setDirection(DcMotor.Direction.FORWARD);
            ElevatorMotor.setDirection(DcMotor.Direction.FORWARD);


            MotorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            ElevatorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        //test

        catch (Exception e)
        {
            telemetry.addData("[ERROR]:", "driving wheels setup");
        }
    }



    double getTime()
    {
        return getRuntime() - startTime;
    }



    float scaleInput(float input)
    {
        input = Range.clip(input, -1, 1);

        if (input > 0)
            return (float)Math.pow(input, 4);

        return -(float)Math.pow(input, 4);
    }


    void done()
    {
        telemetry.addData("Finished in:", getTime());
    }

    public void closeGripper(){
        //TEST CODE
        if(closed ){
            armR.setPosition(.28);
            armL.setPosition(.30);
            closed = false;
        }
        else  {
            armR.setPosition(.66);
            armL.setPosition(.12);

            closed = true;
        }
    }
    public void closeUpperGripper(){

        if(closedUpper ){
            armR.setPosition(.28);
            armL.setPosition(.30);
            closedUpper = false;
        }
        else  {
            armR.setPosition(.66);
            armL.setPosition(.12);

            closedUpper = true;
        }
    }


    public void omniDrive(double power, int direction)
    {
         /*   MotorFL.setPower(y-x);
            MotorBL.setPower(x-y);
            MotorFR.setPower(x-y);
            MotorBR.setPower(y-x);*/
        switch (direction) {
            case right:
                MotorFL.setPower(-power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(-power);
                break;
            case left:
                MotorFL.setPower(power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(power);
                break;
            case forward:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            case backward:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case dRF:
                MotorFL.setPower(0);
                MotorBL.setPower(power);
                MotorFR.setPower(0);
                MotorBR.setPower(-power);
                break;
            case dRB:
                MotorFL.setPower(0);
                MotorBL.setPower(-power);
                MotorFR.setPower(0);
                MotorBR.setPower(power);
                break;
            case dLF:
                MotorFL.setPower(power);
                MotorBL.setPower(0);
                MotorFR.setPower(-power);
                MotorBR.setPower(0);
                break;
            case dLB:
                MotorFL.setPower(-power);
                MotorBL.setPower(0);
                MotorFR.setPower(power);
                MotorBR.setPower(0);
                break;
            case turnC:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case turnCC:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            default:
                MotorBL.setPower(0);
                MotorBR.setPower(0);
                MotorFL.setPower(0);
                MotorFR.setPower(0);

        }
    }

    public void omniDrive(double power, int direction, int time)
    {
        long startTime;
        startTime = currentTimeMillis();
        switch (direction) {
            case right:
                MotorFL.setPower(-power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(-power);
                break;
            case left:
                MotorFL.setPower(power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(power);
                break;
            case forward:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            case backward:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case dRF:
                MotorFL.setPower(0);
                MotorBL.setPower(power);
                MotorFR.setPower(0);
                MotorBR.setPower(-power);
                break;
            case dRB:
                MotorFL.setPower(0);
                MotorBL.setPower(-power);
                MotorFR.setPower(0);
                MotorBR.setPower(power);
                break;
            case dLF:
                MotorFL.setPower(power);
                MotorBL.setPower(0);
                MotorFR.setPower(-power);
                MotorBR.setPower(0);
                break;
            case dLB:
                MotorFL.setPower(-power);
                MotorBL.setPower(0);
                MotorFR.setPower(power);
                MotorBR.setPower(0);
                break;
            case turnC:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case turnCC:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            default:
                MotorBL.setPower(0);
                MotorBR.setPower(0);
                MotorFL.setPower(0);
                MotorFR.setPower(0);

        }
        while (currentTimeMillis() < startTime + time) ;
        MotorBL.setPower(0);
        MotorBR.setPower(0);
        MotorFL.setPower(0);
        MotorFR.setPower(0);
    }

    public String detectColor(){
        if (color.red() > 100){
            return "red";
        } else if (color.blue() > 100){
            return "blue";
        }
        return "Color not found";
    }

    public void toggleColorSensorArm(){
          if (jewelArmDown) {
              jewelArm.setPosition(1);
              jewelArmDown = false;
          } else {
            jewelArm.setPosition(0);
            while (jewelArm.getPosition() != 0);
            jewelArmDown = true;
        }
        //jewelArm.setPosition(.9);
    }
    /*
    //drives to correct throw dist and returns if done
    boolean driveToDist(double dist){
        if(sonar.getUltrasonicLevel() == dist){
            setPower(0);
            return true;
        }

        if(sonar.getUltrasonicLevel() > dist){
            setPower(0.15f);
        } else if(sonar.getUltrasonicLevel() < dist){
            setPower(-0.15f);
        }
        return false;
    }
    */
}

