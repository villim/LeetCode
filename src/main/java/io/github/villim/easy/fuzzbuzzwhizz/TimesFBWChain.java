package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

public class TimesFBWChain extends AbstractFBWChain {

	public TimesFBWChain(AbstractFBWChain next) {
		this.nextChain = next;
	}

	public TimesFBWChain() {
	}

	protected String handle(HashMap<Integer, String> fbwNumber,
			int currentNumber) {

		StringBuilder sb = new StringBuilder();
		for (int key : fbwNumber.keySet()) {
			if (currentNumber % key == 0) {
				sb.append(fbwNumber.get(key));
			}
		}

		String value = sb.toString().trim();
		if (!value.equals("")) {
			return value;
		}

		return super.handle(fbwNumber, currentNumber);
	}

}
