package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoLeftParkClose v4",group = "Concept")
public class AutoLeftParkClose extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/5,Robot.MAX_DRIVE_SPEED);
            robot.strafeRight(Robot.FIELD_TILE*3.5,Robot.MAX_DRIVE_SPEED);

        }
    }
}
