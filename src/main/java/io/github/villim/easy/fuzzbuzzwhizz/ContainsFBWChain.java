package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

public class ContainsFBWChain extends AbstractFBWChain {

	public ContainsFBWChain(AbstractFBWChain next) {
		this.nextChain = next;
	}

	public ContainsFBWChain() {
	}

	@Override
	public String handle(HashMap<Integer, String> fbwNumber, int currentNumber) {
		for (int key : fbwNumber.keySet()) {
			String current = String.valueOf(currentNumber);
			if (current.contains(String.valueOf(key))) {
				return fbwNumber.get(key);
			}
		}

		return super.handle(fbwNumber, currentNumber);
	}

}
