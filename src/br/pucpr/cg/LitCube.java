package br.pucpr.cg;

import br.pucpr.mage.*;
import org.joml.Matrix4f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class LitCube implements Scene {
    private Keyboard keys = Keyboard.getInstance();

    private static final float SPEED = (float) Math.toRadians(180);
    
    private Mesh mesh;
    private float angleX = 0.0f;
    private float angleY = 0.5f;
    private Camera camera = new Camera();
    
    @Override
    public void init() {
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        mesh = MeshFactory.createCube();
        camera.getPosition().y = 1.0f;
    }

    @Override
    public void update(float secs) {
        if (keys.isPressed(GLFW_KEY_ESCAPE)) {
            glfwSetWindowShouldClose(glfwGetCurrentContext(), true);
            return;
        }

        if (keys.isDown(GLFW_KEY_A)) {
            angleY += SPEED * secs;
        } else if (keys.isDown(GLFW_KEY_D)) {
            angleY -= SPEED * secs;
        }
        
        if (keys.isDown(GLFW_KEY_W)) {
            angleX += SPEED * secs;
        } else if (keys.isDown(GLFW_KEY_S)) {
            angleX -= SPEED * secs;
        }
    }

@Override
public void draw() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
    Shader shader = mesh.getShader();
    shader.bind()
        .setUniform("uProjection", camera.getProjectionMatrix())
        .setUniform("uView", camera.getViewMatrix());
    shader.unbind();

    mesh.setUniform("uWorld", new Matrix4f().rotateY(angleY).rotateX(angleX));
    mesh.draw();
}

    @Override
    public void deinit() {
    }

    public static void main(String[] args) {
        new Window(new LitCube(), "Cube with lights", 800, 600).show();
    }
}
