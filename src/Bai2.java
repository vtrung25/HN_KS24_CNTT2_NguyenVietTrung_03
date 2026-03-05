import java.util.*;

public class Bai2 {
    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập 1 chuỗi kí tự: ");
        String input = sc.nextLine();

        if(input.trim().isEmpty()){
            System.out.println("Lỗi: chuỗi không hợp lệ");
            return;
        }

        input = input.toLowerCase();

        for(int i = 0; i < input.length(); i++){

            char c = input.charAt(i);

            if(c == ' '){
                continue;
            }

            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        List<Character> keys = new ArrayList<>(map.keySet());

        for(int i = 0; i < keys.size() - 1; i++){
            for(int j = 0; j < keys.size() - i - 1; j++){
                if(keys.get(j) > keys.get(j+1)){
                    char temp = keys.get(j);
                    keys.set(j, keys.get(j+1));
                    keys.set(j+1, temp);
                }
            }
        }

        int max = 0;
        for(int value : map.values()){
            if(value > max){
                max = value;
            }
        }

        for(char c : keys){
            System.out.println(c + " xuất hiện: " + map.get(c) + " lần");
        }

        System.out.print("Ký tự xuất hiện nhiều nhất: ");

        for(char c : keys){
            if(map.get(c) == max){
                System.out.print(c + " ");
            }
        }

        System.out.println("(" + max + " lần)");
    }
}