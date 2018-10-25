
/* Copyright (c) 2017 FIRST. All rights reserved.
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

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Androidp Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOp", group="Iterative OpMode")
//@Disabled
public class TeleOp extends OpMode {

    // Declare OpMode members.
       private ElapsedTime runtime = new ElapsedTime();

    //DC Motors
    private DcMotor leftDrive = null;   //Tank Drive
    private DcMotor rightDrive = null;  //Tank Drive

    private DcMotor Intake = null;  //Intake Motor
    private DcMotor Lift = null;    //Stage 1 lift
    private DcMotor Arm = null;   //Stage 2 lift

    //Servo
    //private Servo Mark = null;   // Marker Servo
    private Servo Pin = null;   // Pin Servo




    //  **This code runs ONCE after driver hits INIT
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        //telemetry.update();

        /* Initialize the hardware variables. Note that the strings used here as parameters
         to 'get' must correspond to the names assigned during the robot configuration
        step (using the FTC Robot Controller app on the phone). */


        //double power = 0.5;

        //Motors
        leftDrive = hardwareMap.get(DcMotor.class, "leftMotor");
        rightDrive = hardwareMap.get(DcMotor.class, "rightMotor");
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        Lift = hardwareMap.get(DcMotor.class, "Lift"); //Phase 1
        Arm = hardwareMap.get(DcMotor.class, "Arm");  //Phase 2

        //Servo
       // Mark = hardwareMap.get(Servo.class, "Marker");
        Pin = hardwareMap.get(Servo.class, "Pin");

        /*Tank Drive: One of the motors need to be set in reverse in order to
        get the robot to drive in the same direction
         */
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);


        //Disable encoders to allow powers to be set
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        // Tell driver to that initalization is complete
        telemetry.addData("Status", "Initialized");
    }

       // *** Code to run REPEATEDLY after the driver hits INIT but before PLAY
       @Override
        public void init_loop(){}

        // Code to run ONCE when the the driver hits PLAY
        public void start(){
            runtime.reset();
        }

       // *** Code to run REPEATEDLY after the driver hits INIT but before STOP
       @Override
        public void loop() {

           //Tank Drive

           //Declare Drive Power; need this in order to make the gamepads work
           //*double leftPower = 0;
           //*double rightPower = 0;
           //*leftDrive.setPower(leftPower);
           //*rightDrive.setPower(rightPower);

           leftDrive.setPower(-gamepad1.left_stick_y);
           rightDrive.setPower(-gamepad1.right_stick_y);


           //Intake
           if (gamepad1.left_trigger > 0.5) {
               Intake.setPower(0.5);
           } else {
               Intake.setPower(0);
           }


           //Reverse Intake
           if (gamepad1.right_trigger > 0.5) {
               Intake.setPower(-0.5);
           } else {
               Intake.setPower(0);
           }


           //Raise/Lower Lift(Phase 1)
           Lift.setPower(gamepad2.right_stick_y);


           //Raise Arm(Phase 2)
           if (gamepad2.right_trigger > 0.5) {
               Arm.setPower(0.5);
           } else {
               Arm.setPower(0);
           }

           //Lower Arm(Phase 1)
           if (gamepad2.left_trigger > 0.5) {
               Arm.setPower(-0.5);
           } else {
               Arm.setPower(0);
           }


           /*
           //Place Marker
           if (gamepad2.left_bumper){
               Mark.setPosition(0);
           }else{
               Mark.setPosition(1);
           }
           */

           //Pull Pin
           if (gamepad2.right_bumper) {
               Pin.setPosition(0);
           } else {
               Pin.setPosition(1);
           }

           //Show the elapsed game time and wheel power.
           telemetry.addData("Status", "Run Time: " + runtime.toString());
       }
           // telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
           // telemetry.update();
           @Override
           public void stop(){
           }



    }




