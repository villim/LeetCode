package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

public class TimesFBWChain extends AbstractFBWChain {

	public TimesFBWChain() {
	}

	public TimesFBWChain(AbstractFBWChain next) {
		this.nextChain = next;
	}

	@Override
	protected String handle(HashMap<Integer, String> fbwNumber,
			int currentNumber) {
		for (int j : fbwNumber.keySet()) {
			if (currentNumber % j == 0) {
				return fbwNumber.get(j);
			}
		}

		return super.handle(fbwNumber, currentNumber);
	}

}
