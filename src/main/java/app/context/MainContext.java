package app.context;

import context.GameContext;

public class MainContext extends GameContext {

	@Override
	public void init() {
		System.out.println("first context init");
	}

	@Override
	public void update() {
		transition(new SecondContext());
	}

	@Override
	public void render() {
	}

	@Override
	public void terminate() {
		System.out.println("first context terminate");
	}

}
