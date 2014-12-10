package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

public abstract class AbstractFBWChain {

	protected AbstractFBWChain nextChain = null;

	protected boolean isContinue = true;

	protected String handle(HashMap<Integer, String> fbwNumber,
			int currentNumber) {
		if (isContinue && nextChain != null) {
			return nextChain.handle(fbwNumber, currentNumber);
		}
		return null;
	}
}
