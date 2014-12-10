package io.github.villim.easy.fuzzbuzzwhizz;

import java.util.HashMap;

/**
 * FizzBuzzWhizz
 * 
 * 你是一名体育老师，在某次课距离下课还有五分钟时，你决定搞一个游戏。此时有100名学生在上课。游戏的规则是：
 * 
 * 1. 你首先说出三个不同的特殊数，要求必须是个位数，比如3、5、7。<br>
 * 2. 让所有学生拍成一队，然后按顺序报数。<br>
 * 3. 学生报数时，如果所报数字是第一个特殊数（3）的倍数，那么不能说该数字，而要说Fizz；如果所报数字是第二个特殊数（5）的倍数，那么要说Buzz；
 * 如果所报数字是第三个特殊数（7）的倍数，那么要说Whizz。<br>
 * 4. 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，比如第一个特殊数和第二个特殊数的倍数，<br>
 * 那么不能说该数字，而是要说FizzBuzz, 以此类推。如果同时是三个特殊数的倍数，那么要说FizzBuzzWhizz。 <br>
 * 5. 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词
 * ，比如本例中第一个特殊数是3，那么要报13的同学应该说Fizz。如果数字中包含了第一个特殊数
 * ，那么忽略规则3和规则4，比如要报35的同学只报Fizz，不报BuzzWhizz。
 * 
 * @author villim
 *
 **/
public class FizzBuzzWhizz {

	private AbstractFBWChain chain;

	public String countOff(HashMap<Integer, String> fbwNumber, int totalNumber) {

		validateParameter(fbwNumber, totalNumber);

		if (getChain() == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= totalNumber; i++) {
			sb.append(getChain().handle(fbwNumber, i));
			if (i < totalNumber) {
				sb.append(",");
			}
		}

		return sb.toString();
	}

	private void validateParameter(HashMap<Integer, String> fbznumber,
			int totalNumber) {
		if (fbznumber == null || fbznumber.size() == 0) {
			throw new IllegalArgumentException(
					"fbznumber can't be null or empty");
		}

		if (totalNumber <= 0) {
			throw new IllegalArgumentException("totalNumber can't less than 1");
		}

		for (int i : fbznumber.keySet()) {
			if (i > 9 || i <= 0) {
				throw new IllegalArgumentException("fbznumber must under 10!");
			}
		}
	}

	public AbstractFBWChain getChain() {
		return chain;
	}

	public void setChain(AbstractFBWChain chain) {
		this.chain = chain;
	}

}
