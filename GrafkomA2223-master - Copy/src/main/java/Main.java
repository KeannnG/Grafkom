import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
    (800,800,"The Amazing World of Gumball");
    private ArrayList<Object> objects
            = new ArrayList<>();

    private ArrayList<Object> arm
            = new ArrayList<>();

    private ArrayList<Object> wrist
            = new ArrayList<>();

    private ArrayList<Object> head
            = new ArrayList<>();

    private ArrayList<Object> leg
            = new ArrayList<>();

    private ArrayList<Object> foot
            = new ArrayList<>();

    private ArrayList<Object> eye
            = new ArrayList<>();

    private ArrayList<Object> black
            = new ArrayList<>();

    private ArrayList<Object> ear
            = new ArrayList<>();

    private ArrayList<Object> nose
            = new ArrayList<>();

    private ArrayList<Object> tail
            = new ArrayList<>();

    private ArrayList<Object> teeth
            = new ArrayList<>();




    private MouseInput mouseInput;
    int countDegree = 0;
    public void init(){
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        //code

        //Richard

        objects.add(new Cylinder(//torso
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objects.get(0).translateObject(2.5f,-0.04f+2.5f,0.0f);
        objects.get(0).scaleObject(0.5f/2.0f,0.3f/2.0f,0.5f/2.0f);

        ear.add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).translateObject(0.3f+2.5f,1.1f+1.7f,0.0f);
        ear.get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(0).translateObject(-0.3f+2.5f,1.1f+1.7f,0.0f);
        ear.get(0).getChildObject().get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        head.add(new Cylinder(//head
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        head.get(0).translateObject(0.0f+2.27f,1.2f+4.2f,0.0f);
        head.get(0).scaleObject(0.55f/2.0f,0.2f/2.0f,0.6f/2.0f);

        eye.add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).translateObject(-0.3f+3.7f,0.7f+2.1f,-0.35f);
        eye.get(0).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(0).translateObject(-0.3f+3.1f,0.7f+2.1f,-0.35f);
        eye.get(0).getChildObject().get(0).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);


        black.add(new Sphere(//1left black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).translateObject(-1.3f+12.5f,2.75f+8.4f,-1.9f);
        black.get(0).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2right black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(0).translateObject(1.1f+12.5f,2.75f+8.4f,-1.9f);
        black.get(0).getChildObject().get(0).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//1 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(1).translateObject(0.0f+12.5f,0.2f+8.2f,-1.3f);
        black.get(0).getChildObject().get(1).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(2).translateObject(0.0f+12.5f,-1.2f+8.2f,-1.3f);
        black.get(0).getChildObject().get(2).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//3 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(3).translateObject(0.0f+12.5f,-2.6f+8.2f,-1.3f);
        black.get(0).getChildObject().get(3).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        nose.add(new EllipsoidWrist(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.3f, 0.5f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        nose.get(0).translateObject(0.0f+6.2f,1.2f+4.1f,-0.65f);
        nose.get(0).scaleObject(0.2f/2.0f,0.2f/2.0f,0.2f/2.0f);

        teeth.add(new Trapezoid(//teeth
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        teeth.get(0).translateObject(0.0f+24.85f,3.0f+17.33f,-3f);
        teeth.get(0).scaleObject(0.05f/2.0f,0.05f/2.0f,0.05f/2.0f);

        arm.add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).translateObject(-0.6f+2.5f,-0.3f+1.66f,0.0f);
        arm.get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(0).translateObject(0.6f+2.5f,-0.3f+1.66f,0.0f);
        arm.get(0).getChildObject().get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).translateObject(-0.6f+2.5f,-0.72f+1.65f,0.1f);
        wrist.get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(0).translateObject(0.6f+2.5f,-0.72f+1.65f,0.1f);
        wrist.get(0).getChildObject().get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f, 0.4f, 0.2f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).translateObject(-0.2f+2.5f,-0.9f+1.66f,0.0f);
        leg.get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f, 0.4f, 0.2f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(0).translateObject(0.2f+2.5f,-0.9f+1.66f,0.0f);
        leg.get(0).getChildObject().get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        foot.add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).translateObject(-0.2f+2.5f,-1.3f+1.66f,-0.1f);
        foot.get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(0).translateObject(0.2f+2.5f,-1.3f+1.66f,-0.1f);
        foot.get(0).getChildObject().get(0).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        tail.add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.5f, 0.8f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        tail.get(0).translateObject(0.0f+3.2f,-0.6f+2.0f,0.35f);
        tail.get(0).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);


        //Gumball


        objects.get(0).getChildObject().add(new Cylinder(//torso
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.97f,0.9f,0.75f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objects.get(0).getChildObject().get(0).translateObject(-3.5f,-5f,0.0f);
        objects.get(0).getChildObject().get(0).scaleObject(0.35f/2.0f,0.24f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(1).translateObject(-2.33f,-2.4f,0.0f);
        ear.get(0).getChildObject().get(1).scaleObject(0.6f/2.0f,0.3f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(2).translateObject(-1.77f,-2.4f,0.0f);
        ear.get(0).getChildObject().get(2).scaleObject(0.6f/2.0f,0.3f/2.0f,0.5f/2.0f);

        head.get(0).getChildObject().add(new Cylinder(//head
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        head.get(0).getChildObject().get(0).translateObject(-2.73f,-4.4f,0.0f);
        head.get(0).getChildObject().get(0).scaleObject(0.45f/2.0f,0.2f/2.0f,0.6f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(1).translateObject(-2.73f,-2.1f,-0.35f);
        eye.get(0).getChildObject().get(1).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(2).translateObject(-3.4f,-2.1f,-0.35f);
        eye.get(0).getChildObject().get(2).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);


        black.get(0).getChildObject().add(new Sphere(//1left black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(4).translateObject(-13.6f,-8.4f,-1.9f);
        black.get(0).getChildObject().get(4).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2right black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(5).translateObject(-10.9f,-8.4f,-1.9f);
        black.get(0).getChildObject().get(5).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//1 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.97f,0.9f,0.75f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(6).translateObject(-12.73f,-10.4f,-1.3f);
        black.get(0).getChildObject().get(6).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.97f,0.9f,0.75f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(7).translateObject(-12.73f,-10.4f,-1.3f);
        black.get(0).getChildObject().get(7).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//3 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.97f,0.9f,0.75f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(8).translateObject(-12.73f,-10.4f,-1.3f);
        black.get(0).getChildObject().get(8).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        nose.get(0).getChildObject().add(new EllipsoidWrist(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.3f, 0.5f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        nose.get(0).getChildObject().get(0).translateObject(-6.12f,-4.5f,-0.65f);
        nose.get(0).getChildObject().get(0).scaleObject(0.2f/2.0f,0.2f/2.0f,0.2f/2.0f);

        teeth.get(0).getChildObject().add(new Trapezoid(//teeth
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        teeth.get(0).getChildObject().get(0).translateObject(-24.47f,-19.4f,-3f);
        teeth.get(0).getChildObject().get(0).scaleObject(0.05f/2.0f,0.05f/2.0f,0.05f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(1).translateObject(-4.14f,-3.1f,0.0f);
        arm.get(0).getChildObject().get(1).scaleObject(0.35f/2.0f,0.5f/2.5f,0.5f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(2).translateObject(-2.86f,-3.1f,0.0f);
        arm.get(0).getChildObject().get(2).scaleObject(0.35f/2.0f,0.5f/2.5f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(1).translateObject(-3.63f,-2.8f,-0.1f);
        wrist.get(0).getChildObject().get(1).scaleObject(0.4f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(2).translateObject(-2.5f,-2.8f,-0.1f);
        wrist.get(0).getChildObject().get(2).scaleObject(0.4f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(1).translateObject(-3.04f,-4.08f,0.0f);
        leg.get(0).getChildObject().get(1).scaleObject(0.5f/2.3f,0.4f/2.3f,0.5f/2.3f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(2).translateObject(-2.6f,-4.08f,0.0f);
        leg.get(0).getChildObject().get(2).scaleObject(0.5f/2.3f,0.4f/2.3f,0.5f/2.3f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(1).translateObject(-2.65f,-3.95f,-0.1f);
        foot.get(0).getChildObject().get(1).scaleObject(0.5f/2.0f,0.4f/2.0f,0.5f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(2).translateObject(-2.26f,-3.95f,-0.1f);
        foot.get(0).getChildObject().get(2).scaleObject(0.5f/2.0f,0.4f/2.0f,0.5f/2.0f);

        tail.get(0).getChildObject().add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        tail.get(0).getChildObject().get(0).translateObject(-3.07f,-3.3f,0.28f);
        tail.get(0).getChildObject().get(0).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f);

        //

        //
        //Anais

        objects.get(0).getChildObject().add(new Trapezoid(//body
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.99f,0.52f,0.08f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objects.get(0).getChildObject().get(1).translateObject(2.9f,-3.4f,0.0f);
        objects.get(0).getChildObject().get(1).scaleObject(0.5f/2.0f,0.3f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(3).translateObject(2.6f,-0.95f,0.0f);
        ear.get(0).getChildObject().get(3).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(4).translateObject(3.25f,-0.95f,0.0f);
        ear.get(0).getChildObject().get(4).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        head.get(0).getChildObject().add(new Sphere(//head
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.9f,
                0.125f,
                36,
                18
        ));
        head.get(0).getChildObject().get(1).translateObject(2.64f,-3.7f,0.0f);
        head.get(0).getChildObject().get(1).scaleObject(0.55f/2.0f,0.2f/2.0f,0.6f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(3).translateObject(3.3f,-1.7f,-0.35f);
        eye.get(0).getChildObject().get(3).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(4).translateObject(4.0f,-1.7f,-0.35f);
        eye.get(0).getChildObject().get(4).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);


        black.get(0).getChildObject().add(new Sphere(//1left black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(9).translateObject(13.2f,-6.8f,-1.9f);
        black.get(0).getChildObject().get(9).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2right black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(10).translateObject(16.0f,-6.8f,-1.9f);
        black.get(0).getChildObject().get(10).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//1 button
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.4f,
                0.4f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(11).translateObject(14.5f,-9.5f,-1.3f);
        black.get(0).getChildObject().get(11).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);


        nose.get(0).getChildObject().add(new EllipsoidWrist(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        nose.get(0).getChildObject().get(1).translateObject(7.3f,-3.8f,-0.65f);
        nose.get(0).getChildObject().get(1).scaleObject(0.2f/2.0f,0.2f/2.0f,0.2f/2.0f);

        teeth.get(0).getChildObject().add(new Trapezoid(//teeth
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        teeth.get(0).getChildObject().get(1).translateObject(29.0f,-12.0f,0.0f);
        teeth.get(0).getChildObject().get(1).scaleObject(0.05f/2.0f,0.05f/2.0f,0.05f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.99f,0.52f,0.08f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(3).translateObject(2.4f,-2.15f,0.0f);
        arm.get(0).getChildObject().get(3).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.99f,0.52f,0.08f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(4).translateObject(3.42f,-2.15f,0.0f);
        arm.get(0).getChildObject().get(4).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(3).translateObject(2.412f,-2.6f,0.0f);
        wrist.get(0).getChildObject().get(3).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(4).translateObject(3.43f,-2.6f,0.0f);
        wrist.get(0).getChildObject().get(4).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(3).translateObject(2.7f,-2.6f,0.0f);
        leg.get(0).getChildObject().get(3).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(4).translateObject(3.1f,-2.6f,0.2f);
        leg.get(0).getChildObject().get(4).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(3).translateObject(2.7f,-3.1f,-0.1f);
        foot.get(0).getChildObject().get(3).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(4).translateObject(3.1f,-3.1f,-0.1f);
        foot.get(0).getChildObject().get(4).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        tail.get(0).getChildObject().add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.98f, 0.63f, 0.62f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        tail.get(0).getChildObject().get(1).translateObject(3.65f,-2.8f,0.35f);
        tail.get(0).getChildObject().get(1).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);
        //

        //
        //Nicole

        objects.get(0).getChildObject().add(new Cylinder(//torso
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objects.get(0).getChildObject().get(2).translateObject(-3.3f,4.5f-0.8f,0.0f);
        objects.get(0).getChildObject().get(2).scaleObject(0.4f/2.0f,0.3f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(5).translateObject(-2.85f,6.0f-0.8f,0.0f);
        ear.get(0).getChildObject().get(5).scaleObject(0.5f/2.0f,0.3f/2.0f,0.5f/2.0f);

        ear.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        ear.get(0).getChildObject().get(6).translateObject(-2.43f,6.0f-0.8f,0.0f);
        ear.get(0).getChildObject().get(6).scaleObject(0.5f/2.0f,0.3f/2.0f,0.5f/2.0f);

        head.get(0).getChildObject().add(new Cylinder(//head
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.0f,
                0.0f,
                0.0f,
                36,
                18
        ));
        head.get(0).getChildObject().get(2).translateObject(-3.3f,8.6f-1.2f,0.0f);
        head.get(0).getChildObject().get(2).scaleObject(0.4f/2.0f,0.2f/2.0f,0.6f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(5).translateObject(-3.5f,4.5f-0.7f,-0.35f);
        eye.get(0).getChildObject().get(5).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);

        eye.get(0).getChildObject().add(new Sphere(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        eye.get(0).getChildObject().get(6).translateObject(-3.1f,4.5f-0.7f,-0.35f);
        eye.get(0).getChildObject().get(6).scaleObject(0.4f/2.0f,0.4f/2.0f,0.4f/2.0f);


        black.get(0).getChildObject().add(new Sphere(//1left black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.3f,
                0.3f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(12).translateObject(-14.0f,18.0f-2.8f,-1.8f);
        black.get(0).getChildObject().get(12).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);

        black.get(0).getChildObject().add(new Sphere(//2right black eye
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.3f,
                0.3f,
                0.125f,
                36,
                18
        ));
        black.get(0).getChildObject().get(13).translateObject(-12.4f,18.0f-2.8f,-1.8f);
        black.get(0).getChildObject().get(13).scaleObject(0.1f/2.0f,0.1f/2.0f,0.1f/2.0f);


        nose.get(0).getChildObject().add(new EllipsoidWrist(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.3f, 0.5f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        nose.get(0).getChildObject().get(2).translateObject(-6.6f,8.7f-1.4f,-0.7f);
        nose.get(0).getChildObject().get(2).scaleObject(0.2f/2.0f,0.2f/2.0f,0.2f/2.0f);

        teeth.get(0).getChildObject().add(new Trapezoid(//teeth
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.9f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.1f,
                0.125f,
                36,
                18
        ));
        teeth.get(0).getChildObject().get(2).translateObject(-10.6f,33.3f-5.4f,-3f);
        teeth.get(0).getChildObject().get(2).scaleObject(0.125f/2.0f,0.05f/2.0f,0.05f/2.0f);

        teeth.get(0).getChildObject().add(new Trapezoid(//skirt
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.5f,
                0.1f,
                0.125f,
                36,
                18
        ));
        teeth.get(0).getChildObject().get(3).translateObject(-1.89f,3.29f-0.83f,0.0f);
        teeth.get(0).getChildObject().get(3).scaleObject(0.7f/2.0f,0.3f/2.0f,0.6f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f,0.78f,0.9f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.1f,
                0.9f,
                0.9f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(5).translateObject(-3.13f,2.7f-0.5f,0.0f);
        arm.get(0).getChildObject().get(5).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        arm.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f,0.78f,0.9f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        arm.get(0).getChildObject().get(6).translateObject(-2.15f,2.7f-0.5f,0.0f);
        arm.get(0).getChildObject().get(6).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);


        wrist.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(5).translateObject(-3.15f,2.25f-0.5f,0.1f);
        wrist.get(0).getChildObject().get(5).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        wrist.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        wrist.get(0).getChildObject().get(6).translateObject(-2.12f,2.25f-0.5f,0.1f);
        wrist.get(0).getChildObject().get(6).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(5).translateObject(-2.82f,1.2f-0.5f,0.0f);
        leg.get(0).getChildObject().get(5).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        leg.get(0).getChildObject().add(new EllipsoidArm(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        leg.get(0).getChildObject().get(6).translateObject(-2.46f,1.2f-0.5f,0.0f);
        leg.get(0).getChildObject().get(6).scaleObject(0.5f/2.0f,0.5f/2.0f,0.5f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(5).translateObject(-2.82f,0.6f-0.5f,-0.1f);
        foot.get(0).getChildObject().get(5).scaleObject(0.5f/2.0f,0.7f/2.0f,0.4f/2.0f);

        foot.get(0).getChildObject().add(new EllipsoidWrist(//2right
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.15f,
                0.15f,
                0.15f,
                36,
                18
        ));
        foot.get(0).getChildObject().get(6).translateObject(-2.46f,0.6f-0.5f,-0.1f);
        foot.get(0).getChildObject().get(6).scaleObject(0.5f/2.0f,0.7f/2.0f,0.4f/2.0f);

        tail.get(0).getChildObject().add(new EllipsoidWrist(//1left
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.3f, 0.78f, 0.9f, 1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        tail.get(0).getChildObject().get(2).translateObject(-3.32f,2.9f-0.5f,0.35f);
        tail.get(0).getChildObject().get(2).scaleObject(0.4f/2.0f,0.4f/2.0f,0.75f/2.0f);


    }
    public void input(){
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            wrist.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            arm.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            head.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            leg.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            foot.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            eye.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            black.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            ear.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            nose.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            tail.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);
            teeth.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, -1.0f);

        }
        if(mouseInput.isLeftButtonPressed()){
            Vector2f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) /
                    (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) /
                    (-window.getHeight()/2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : "+pos.x+" y : "+pos.y);
            }
        }

    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
            for(Object object: objects){
                object.draw();
            }

            for(Object object: arm){
                object.draw();
            }

            for(Object object: wrist){
                object.draw();
            }

            for(Object object: head){
                object.draw();
            }

            for(Object object: leg){
                object.draw();
            }

            for(Object object: foot){
                object.draw();
            }

            for(Object object: eye){
                object.draw();
            }

            for(Object object: black){
                object.draw();
            }

            for(Object object: ear){
                object.draw();
            }

            for(Object object: nose){
                object.draw();
            }

            for(Object object: tail){
                object.draw();
            }

            for(Object object: teeth){
                object.draw();
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}