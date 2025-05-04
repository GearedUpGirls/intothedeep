package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoRightPush v3",group = "Concept")
public class AutoRightPush extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/7,Robot.MAX_DRIVE_SPEED);
            robot.strafeLeft(Robot.FIELD_TILE*3,Robot.MAX_DRIVE_SPEED);

        }
    }
}

