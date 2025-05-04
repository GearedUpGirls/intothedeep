package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoLeftPushParkFar v3",group = "Concept")
public class AutoLeftPushParkFar extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/6,Robot.MAX_DRIVE_SPEED);
            robot.strafeLeft(Robot.FIELD_TILE*0.75,Robot.MAX_DRIVE_SPEED);
            robot.strafeRight(Robot.FIELD_TILE*5.3,Robot.MAX_DRIVE_SPEED);

        }
    }
}

