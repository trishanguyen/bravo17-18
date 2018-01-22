package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import static java.lang.System.currentTimeMillis;

public abstract class HardwareSad extends LinearOpMode
{
    //public HiTechnicNxtColorSensor colorSensor;
    public ColorSensor color;

    public DcMotor MotorFL, MotorBL, MotorFR, MotorBR, ElevatorMotor;

   //private CRServo elevator;
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
            MotorBL = hwMap.dcMotor.get("blmotor");
            MotorBR = hwMap.dcMotor.get("brmotor");
            ElevatorMotor = hwMap.dcMotor.get("elevatormotor");


            MotorBL.setDirection(DcMotor.Direction.FORWARD);
            MotorBR.setDirection(DcMotor.Direction.FORWARD);
            ElevatorMotor.setDirection(DcMotor.Direction.FORWARD);
            MotorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            ElevatorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        //test

        catch (Exception e)
        {
            telemetry.addData("[ERROR]:", "driving wheels setup");
        }
    }
    public void elevator(double power){
        ElevatorMotor.setPower(power);

    }


    double getTime()
    {
        return getRuntime() - startTime;
    }

    void done()
    {
        telemetry.addData("Finished in:", getTime());
    }

    public void sadDrive(double power, int direction){
        long startTime;
        startTime = currentTimeMillis();
        switch (direction) {
            case right:
                MotorBL.setPower(-power);
                MotorBR.setPower(-power);
                break;
            case left:
                MotorBL.setPower(power);
                MotorBR.setPower(power);
                break;
            case forward:
                MotorBL.setPower(power);
                MotorBR.setPower(-power);
                break;
            case backward:
                MotorBL.setPower(-power);
                MotorBR.setPower(power);
                break;
            default:
                MotorBL.setPower(0);
                MotorBR.setPower(0);

        }

    }

    public void sadDrive(double power, int direction, int time){
        long startTime;
        startTime = currentTimeMillis();
        switch (direction) {
            case right:
                MotorBL.setPower(-power);
                MotorBR.setPower(-power);
                break;
            case left:
                MotorBL.setPower(power);
                MotorBR.setPower(power);
                break;
            case forward:
                MotorBL.setPower(power);
                MotorBR.setPower(-power);
                break;
            case backward:
                MotorBL.setPower(-power);
                MotorBR.setPower(power);
                break;
            default:
                MotorBL.setPower(0);
                MotorBR.setPower(0);

        }
        while (currentTimeMillis() < startTime + time);
        MotorBR.setPower(0);
        MotorBL.setPower(0);
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

