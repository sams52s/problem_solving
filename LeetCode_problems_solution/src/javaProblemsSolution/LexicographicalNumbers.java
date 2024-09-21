package javaProblemsSolution;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for(int i=1; i<=9; i++){
            func(i,n,result);
        }
        return result;
    }

//**
// Even though the func method returns void, it works because it modifies the result list directly, which is passed by reference.
// This means the changes made to result inside func (i.e., adding numbers) affect the original list in lexicalOrder.
// **
    private void func(int x, int n, List<Integer> result){
        if(x > n) return;
        result.add(x);

        for(int i=0; i<=9; i++){
            int temp = x*10+i;
            if(temp > n) break;
            func(temp,n,result);
        }
    }
}

// Reference passing: In Java, objects (like List<Integer>) are passed by reference,
// meaning the result list in lexicalOrder is the same object that is being modified in func.
//
//   Recursive modification: Each time func is called, it appends a number to result and then recursively builds more numbers by appending digits (e.g., 10, 11, 12, etc.).
//   This modifies the original list with the correct lexicographical order.

