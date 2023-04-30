package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class EllipsoidArm extends Circle{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public EllipsoidArm(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                        int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        ellipsoid(0.15f, 0.1f, 0.49f);
        setupVAOVBO();
    }

    public void ellipsoid(float a, float b, float c) {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        ArrayList<Vector3f> normals = new ArrayList<>();

        int stacks = 32;
        int slices = 64;

        for (int i = 0; i <= stacks; i++) {
            double phi = Math.PI * i / stacks;
            for (int j = 0; j <= slices; j++) {
                double theta = 2.0 * Math.PI * j / slices;
                float x = (float) (a * Math.cos(theta) * Math.sin(phi));
                float y = (float) (c * Math.sin(theta) * Math.sin(phi));
                float z = (float) (b * Math.cos(phi));
                temp.add(new Vector3f(x, y, z));
                normals.add(new Vector3f(x / a, y / c, z / b).normalize());
            }
        }

        this.vertices = temp;

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < stacks; i++) {
            for (int j = 0; j < slices; j++) {
                int first = (i * (slices + 1)) + j;
                int second = first + slices + 1;
                indices.add(first);
                indices.add(second);
                indices.add(first + 1);

                indices.add(second);
                indices.add(second + 1);
                indices.add(first + 1);
            }
        }

    }






}
