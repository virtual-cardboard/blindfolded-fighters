package logic.card;

import java.util.List;

import logic.State;

public abstract class EffectNode {

	public abstract List<EffectEvent> resolve(State state);

}
