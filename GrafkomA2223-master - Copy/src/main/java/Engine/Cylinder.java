package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Cylinder extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public Cylinder(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        //createBox();
        //createSphere();
        //createHyperboloid();
        //createHyperboloid2();
        //ellipticCone();
        //ellipticParaboloid();
        //hyperboloidParabolic();
        //ellipticCylinder();
        //closedCylinder();
        closedEllipticalCylinder(0.5f, 1f);
        setupVAOVBO();
    }
    public void createHyperboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float z = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float x = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void createHyperboloid2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float z = 0.5f * (float)((Math.tan(v)) * Math.cos(u));
                float y = 0.5f * (float)((Math.tan(v)) * Math.sin(u));
                float x = 0.5f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void ellipticCone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.cos(u));
                float y = (float) (0.5f * v * Math.sin(u));
                float z = (float) (0.5f * v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void ellipticParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.cos(u));
                float y = (float) (0.5f * v * Math.sin(u));
                float z = (float) (Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void hyperboloidParabolic() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 10; v+=0.1){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.tan(u));
                float z = (float) (0.5f * v * (1/Math.cos(u)));
                float y = (float) (Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void ellipticCylinder() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float radius = 0.5f; // radius of the base of the cylinder
        float height = 1.0f; // height of the cylinder

        for(double v = -Math.PI; v<= Math.PI; v+=Math.PI/60){
            for(double u = 0; u<= height; u+=height/10){
                float x = (float) (radius * Math.cos(v));
                float y = (float) (radius * Math.sin(v));
                float z = (float) (u);
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void closedCylinder() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float height = 1.5f;
        int sides = 36;

        // Top cap
        for(int i = 0; i < sides; i++){
            double theta = 2.0 * Math.PI * i / sides;
            float x = (float) Math.cos(theta) / 2;
            float y = height / 2;
            float z = (float) Math.sin(theta) / 2;
            temp.add(new Vector3f(x,y,z));
        }

        // Sides
        for(int i = 0; i < sides; i++){
            double theta = 2.0 * Math.PI * i / sides;
            float x = (float) Math.cos(theta) / 2;
            float y1 = height / 2;
            float z = (float) Math.sin(theta) / 2;
            float y2 = -height / 2;
            temp.add(new Vector3f(x,y1,z));
            temp.add(new Vector3f(x,y2,z));
        }

        // Bottom cap
        for(int i = 0; i < sides; i++){
            double theta = 2.0 * Math.PI * i / sides;
            float x = (float) Math.cos(theta) / 2;
            float y = -height / 2;
            float z = (float) Math.sin(theta) / 2;
            temp.add(new Vector3f(x,y,z));
        }

        this.vertices = temp;
    }


    public void closedEllipticalCylinder(float a, float b) {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float height = 1.5f;
        int sides = 36;

        // Top cap
        for (int i = 0; i < sides; i++) {
            double theta = 2.0 * Math.PI * i / sides;
            float x = b * (float) Math.sin(theta) / 2;
            float y = height / 2;
            float z = a * (float) Math.cos(theta) / 2;
            temp.add(new Vector3f(x, y, z));
        }

        // Sides
        for (int i = 0; i < sides; i++) {
            double theta = 2.0 * Math.PI * i / sides;
            float x = b * (float) Math.sin(theta) / 2;
            float y1 = height / 2;
            float z = a * (float) Math.cos(theta) / 2;
            float y2 = -height / 2;
            temp.add(new Vector3f(x, y1, z));
            temp.add(new Vector3f(x, y2, z));
        }

        // Bottom cap
        for (int i = 0; i < sides; i++) {
            double theta = 2.0 * Math.PI * i / sides;
            float x = b * (float) Math.sin(theta) / 2;
            float y = -height / 2;
            float z = a * (float) Math.cos(theta) / 2;
            temp.add(new Vector3f(x, y, z));
        }

        this.vertices = temp;
    }





}
