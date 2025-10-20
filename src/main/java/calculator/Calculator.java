package calculator;

import java.util.regex.Pattern;

public class Calculator {
    
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
        String distinct = "[,:]";
        String text = input;
        
        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            
            String customDistinct = input.substring(2, endIndex);
            distinct = Pattern.quote(customDistinct);
            text = input.substring(endIndex + 2);
        }
        
        // 숫자 분리
        String[] numbers = text.split(distinct);
        
        int sum = 0;
        for (String num : numbers) {
            String str = num.trim();
            
            if (str.isEmpty()) {
                continue;
            }
            
            int value = Integer.parseInt(str);
            
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            
            sum += value;
        }
        
        return sum;
    }
}