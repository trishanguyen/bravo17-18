//Blue Left
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
@Autonomous( name = "AutoRL" )
public class AutonomousRL extends HardwareSad
{
    public Servo armL,armR,armLUpperLeft,armRUpper,jewelArm;
    long time;
    @Override
    public void runOpMode()
    {
        armL = hardwareMap.servo.get("armL");
        armR = hardwareMap.servo.get("armR");

        waitForStart();

        init(hardwareMap);
        VuforiaLocalizer vuforia;
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AdCwzDH/////AAAAGeDkDS3ukU9+lIXc19LMh+cKk29caNhOl8UqmZOymRGwVwT1ZN8uaPdE3Q+zceDu9AKNsqL9qLblSFV" +
                "/x8Y3jfOZdjMFs0CQSQOEyWv3xfJsdSmevXDQDQr+4KI31HY2YSf/KB/kyxfuRMk4Pi+vWS+oLl65o7sWPiyFgzoM74ENyb" +
                "j4FgteD/2b6B+UFuwkHWKBNpp18wrpkaiFfr/FCbRFcdWP5mrjlEZM6eOj171dybw97HPeZbGihnnxOeeUv075O7P167AVq" +
                "aiPy2eRK7OCubR32KXOqQKoyF6AXp+qu2cOTApXS5dqOOseEm+HE4eMF0S2Pld3i5AWBIR+JlPXDuc9LwoH2Q8iDwUK1+4g";;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        long currentTime = currentTimeMillis();
        RelicRecoveryVuMark vuMark = null;
        while (currentTimeMillis() -  currentTime < 2000) {
            vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                break;

            }
        }
        armR.setPosition(.28);
        armL.setPosition(.70);

//        long startTime = currentTimeMillis();
        ColorSensor color = hardwareMap.colorSensor.get("colorSensor");
        jewelArm  = hardwareMap.servo.get("jewel");
//        armR.setPosition(.56);
//        armL.setPosition(.35);
//        elevator(-1);
//        chersTimer(100);
//        elevator(0);
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
//        sadDrive(.5,Hardware.backward,2400);
        sadDrive(.5,Hardware.forward,1400);
        chersTimer(500);
//        sadDrive(.5,Hardware.left,1300);



        if(vuMark.equals(RelicRecoveryVuMark.LEFT)){
            sadDrive(.5, Hardware.forward,500);
        }
        else if(vuMark.equals( RelicRecoveryVuMark.CENTER)){
            sadDrive(.5, Hardware.forward,600);
        }
        else if(vuMark.equals(RelicRecoveryVuMark.RIGHT)){
            sadDrive(.5, Hardware.forward,700);
        } else {
            sadDrive(.5,Hardware.forward,500);
        }
        sadDrive(.5,Hardware.left,1300);
        sadDrive(.5,Hardware.backward,500);
        sadDrive(0,Hardware.forward);
    }
}
