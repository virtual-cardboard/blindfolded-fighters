package app;

import app.context.MainContext;
import nengen.Nengen;

public class Main {

	public static void main(String[] args) {
		MainContext context = new MainContext();

		Nengen nengen = new Nengen();
		nengen.configure()
				.setWindowDim(800, 600)
				.setWindowName("Blindfolded Fighters")
				.setFrameRate(60)
				.setTickRate(10)
				.debug();
		nengen.startNengen(context);
	}

}
