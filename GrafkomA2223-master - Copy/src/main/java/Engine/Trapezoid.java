package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Trapezoid extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public Trapezoid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        TrapezoidalPrism();
        setupVAOVBO();
    }
    public void TrapezoidalPrism() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float height = 1f;
        float bottomWidth = 1f;
        float topWidth = 0.5f;
        float depth = 0.5f;

        // Bottom face
        temp.add(new Vector3f(bottomWidth / 2, -height / 2, depth / 2));
        temp.add(new Vector3f(bottomWidth / 2, -height / 2, -depth / 2));
        temp.add(new Vector3f(-bottomWidth / 2, -height / 2, -depth / 2));
        temp.add(new Vector3f(-bottomWidth / 2, -height / 2, depth / 2));

        // Top face
        temp.add(new Vector3f(topWidth / 2, height / 2, depth / 2));
        temp.add(new Vector3f(topWidth / 2, height / 2, -depth / 2));
        temp.add(new Vector3f(-topWidth / 2, height / 2, -depth / 2));
        temp.add(new Vector3f(-topWidth / 2, height / 2, depth / 2));

        // Front face
        temp.add(temp.get(0));
        temp.add(temp.get(1));
        temp.add(temp.get(5));
        temp.add(temp.get(4));

        // Back face
        temp.add(temp.get(3));
        temp.add(temp.get(2));
        temp.add(temp.get(6));
        temp.add(temp.get(7));

        // Left face
        temp.add(temp.get(7));
        temp.add(temp.get(4));
        temp.add(temp.get(5));
        temp.add(temp.get(6));

        // Right face
        temp.add(temp.get(2));
        temp.add(temp.get(3));
        temp.add(temp.get(0));
        temp.add(temp.get(1));

        int[] indices = {
                0, 1, 2, 2, 3, 0, // Bottom face
                4, 5, 6, 6, 7, 4, // Top face
                8, 9, 10, 10, 11, 8, // Front face
                12, 13, 14, 14, 15, 12, // Back face
                16, 17, 18, 18, 19, 16, // Left face
                20, 21, 22, 22, 23, 20  // Right face
        };

        this.vertices = temp;
    }

//    public void trapezoidalPrism() {
//        vertices.clear();
//        indices.clear();
//
//        float bottomWidth = 1.0f;
//        float topWidth = 0.5f;
//        float height = 1.5f;
//        float depth = 0.5f;
//
//        // Bottom face
//        vertices.add(new Vector3f(-bottomWidth/2, -height/2, depth/2));
//        vertices.add(new Vector3f(bottomWidth/2, -height/2, depth/2));
//        vertices.add(new Vector3f(bottomWidth/2, -height/2, -depth/2));
//        vertices.add(new Vector3f(-bottomWidth/2, -height/2, -depth/2));
//
//        // Top face
//        vertices.add(new Vector3f(-topWidth/2, height/2, depth/2));
//        vertices.add(new Vector3f(topWidth/2, height/2, depth/2));
//        vertices.add(new Vector3f(topWidth/2, height/2, -depth/2));
//        vertices.add(new Vector3f(-topWidth/2, height/2, -depth/2));
//
//        // Front face
//        vertices.add(vertices.get(0));
//        vertices.add(vertices.get(1));
//        vertices.add(vertices.get(4));
//        vertices.add(vertices.get(5));
//
//        // Back face
//        vertices.add(vertices.get(2));
//        vertices.add(vertices.get(3));
//        vertices.add(vertices.get(6));
//        vertices.add(vertices.get(7));
//
//        // Left face
//        vertices.add(vertices.get(3));
//        vertices.add(vertices.get(0));
//        vertices.add(vertices.get(7));
//        vertices.add(vertices.get(4));
//
//        // Right face
//        vertices.add(vertices.get(1));
//        vertices.add(vertices.get(2));
//        vertices.add(vertices.get(5));
//        vertices.add(vertices.get(6));
//
//        // Indices
//        indices.add(0); indices.add(1); indices.add(2);
//        indices.add(0); indices.add(2); indices.add(3);
//        indices.add(4); indices.add(6); indices.add(5);
//        indices.add(4); indices.add(7); indices.add(6);
//        indices.add(8); indices.add(10); indices.add(9);
//        indices.add(8); indices.add(11); indices.add(10);
//        indices.add(12); indices.add(14); indices.add(13);
//        indices.add(12); indices.add(15); indices.add(14);
//        indices.add(16); indices.add(18); indices.add(17);
//        indices.add(16); indices.add(19); indices.add(18);
//
//        this.indices = indices;
//    }



}
