/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
 * This file contains an example of a Linear "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode is executed.
 *
 * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
 * This code will work with either a Mecanum-Drive or an X-Drive train.
 * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
 * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
 *
 * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
 *
 * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
 * Each motion axis is controlled by one Joystick axis.
 *
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 *
 * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
 * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
 * the direction of all 4 motors (see code below).
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name = "TeleOp_12890_IntoTheDeep v36", group = "Linear OpMode")
public class TeleOp_12890_Centerstage extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    Robot robot = new Robot();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Map Controls
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x;
            double pivotArmControl = gamepad2.left_stick_y;
            double slideControl = gamepad2.right_stick_y;
//            boolean retractHangingMotorButtonPressed = gamepad2.a;
//            boolean extendHangingMotorButtonPressed = gamepad2.y;
            boolean openClawButtonPressed = gamepad2.left_bumper;
            boolean closeClawButtonPressed = gamepad2.right_bumper;
            boolean completelyOpenClawButtonPressed = gamepad2.b;
            boolean startRightClawButtonPressed = gamepad2.dpad_right;
            boolean startLeftClawButtonPresses = gamepad2.dpad_left;

            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            double leftFrontPower = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower = axial - lateral + yaw;
            double rightBackPower = axial + lateral - yaw;
            double pivotArmPower = pivotArmControl;
            double slidePower = slideControl;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            double max;
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower /= max;
                rightFrontPower /= max;
                leftBackPower /= max;
                rightBackPower /= max;
            }

            // Send calculated power to wheels
            robot.leftFrontDrive.setPower(leftFrontPower * 0.5);
            robot.rightFrontDrive.setPower(rightFrontPower * 0.5);
            robot.leftBackDrive.setPower(leftBackPower * 0.5);
            robot.rightBackDrive.setPower(rightBackPower * 0.5);

            if (openClawButtonPressed) {
                robot.openClaw();
            } else if (closeClawButtonPressed) {
                robot.closeClaw();
            }
//
//            if(completelyOpenClawButtonPressed){
//                robot.completelyOpenClaw();
//            }

//            if (gamepad2.y) {
//                robot.pivotArmMotor.setTargetPosition(0);
//                robot.pivotArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                robot.pivotArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            }

//            if (extendHangingMotorButtonPressed) {
//                robot.extendHangingMotor(1);
//            } else {
//                robot.extendHangingMotor(0);
//            }
//
//            if (retractHangingMotorButtonPressed) {
//                robot.retractHangingMotor(1);
//            } else {
//                robot.retractHangingMotor(0);
//            }
            robot.pivotArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            if (pivotArmControl > 0) {
                robot.pivotArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                robot.pivotArmMotor.setPower(pivotArmControl);
//                robot.armPivotUp(pivotArmPower);
            } else if (pivotArmControl<0){
                robot.pivotArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                robot.pivotArmMotor.setPower(pivotArmControl);
            }
            else {
                robot.pivotArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
              robot.pivotArmMotor.setPower(0);
            }

//            if (gamepad2.x) {
//                robot.autoArmPivot(-5, 0.5);
//            }

            if (slideControl > 0) {
                robot.extendSlide(slidePower);
            }else {
                robot.slideMotor.setPower(0);
            }

            if (slideControl < 0) {
                robot.retractSlide(slidePower);
            }else {
                robot.slideMotor.setPower(0);
            }

            if (startLeftClawButtonPresses){
                robot.leftClaw.setPosition(0);
            }

            if (startRightClawButtonPressed){
                robot.rightClaw.setPosition(0);
            }
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }
}