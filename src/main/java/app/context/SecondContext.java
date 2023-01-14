package app.context;

import static common.NengenUtil.readFileAsString;
import static common.colour.Colour.rgba;
import static lwjgl.render.ShaderType.FRAGMENT;
import static lwjgl.render.ShaderType.VERTEX;

import java.io.File;
import java.net.URL;

import context.GameContext;
import context.input.event.KeyPressedInputEvent;
import context.input.event.KeyReleasedInputEvent;
import context.input.event.MouseScrolledInputEvent;
import lwjgl.render.ElementBufferObject;
import lwjgl.render.Shader;
import lwjgl.render.ShaderProgram;
import lwjgl.render.VertexArrayObject;
import lwjgl.render.VertexBufferObject;

public class SecondContext extends GameContext {

	private VertexArrayObject vao;
	private ShaderProgram program;

	@Override
	public void init() {
		System.out.println("second context init");

		float[] vertices = {
				-0.5f, -0.5f, 0.0f,
				0.5f, -0.5f, 0.0f,
				0.0f, 0.5f, 0.0f
		};

		int[] indices = {
				0, 1, 2
		};

		VertexBufferObject vbo = new VertexBufferObject().data(vertices).components(3).index(0).load();
		ElementBufferObject ebo = new ElementBufferObject().indices(indices).load();
		vao = new VertexArrayObject().vbos(vbo).ebo(ebo).load();
		Shader vertexShader = new Shader().type(VERTEX).source(readFile("../shaders/vertex.glsl")).load();
		Shader fragmentShader = new Shader().type(FRAGMENT).source(readFile("../shaders/fragment.glsl")).load();
		program = new ShaderProgram().attach(vertexShader).attach(fragmentShader).load();
	}

	private String readFile(String name) {
		URL resource = getClass().getResource(name);
		assert resource != null : "Could not find resource " + name;
		File file = new File(resource.getFile());
		return readFileAsString(file);
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		background(rgba(100, 100, 100, 255));
		program.use(glContext());
		vao.draw(glContext());
	}

	@Override
	public void terminate() {
		System.out.println("second context terminate");
	}

	public void input(KeyPressedInputEvent event) {
		int key = event.code();
		System.out.println("second context key pressed: " + key);
	}

	public void input(KeyReleasedInputEvent event) {
		int key = event.code();
		System.out.println("second context key released: " + key);
	}

	public void input(MouseScrolledInputEvent event) {
		float amount = event.yAmount();
		System.out.println("second context mouse scrolled: " + amount);
	}

}
