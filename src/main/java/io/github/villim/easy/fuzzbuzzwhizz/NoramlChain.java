package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

public class NoramlChain extends AbstractFBWChain {

	public NoramlChain() {
	}

	public NoramlChain(AbstractFBWChain next) {
		this.nextChain = next;
	}

	@Override
	protected String handle(HashMap<Integer, String> fbwNumber,
			int currentNumber) {
		this.isContinue = false;
		return "" + currentNumber;
	}

}
