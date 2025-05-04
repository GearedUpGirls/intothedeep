package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoMiddlePushParkFar v2",group = "Concept")
public class AutoMiddlePushParkFar extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/6,Robot.MAX_DRIVE_SPEED);
            robot.strafeLeft(Robot.FIELD_TILE*2,Robot.MAX_DRIVE_SPEED);
            robot.strafeRight(Robot.FIELD_TILE*5.35,Robot.MAX_DRIVE_SPEED);

        }
    }
}

