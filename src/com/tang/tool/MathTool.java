package com.tang.tool;

/**
 * 数值计算工具类
 * @author TangXW
 *
 */
public class MathTool {
	// 取得大于某个double值的最小整数
	public static int getMaxInt(int num1, int num2){
		int num = num1 / num2;
		if((num1 % num2) != 0){
			num += 1;
		}
		
		return num;
	}
}
