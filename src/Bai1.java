import java.util.*;

public class Bai1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();

        if(n <= 0){
            System.out.println("Lỗi: số lượng phần tử không hợp lệ");
            return;
        }

        for(int i = 0; i < n; i++){
            System.out.printf("Nhập phần tử thứ %d: ", i + 1);
            int x = sc.nextInt();
            list.add(x);
        }

        int max = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }

        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 0; j < list.size() - i - 1; j++){
                if(list.get(j) > list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }

        double sum = 0;
        for(int x : list){
            sum += x;
        }
        double avg = sum / list.size();

        int even = 0;
        int odd = 0;

        for(int x : list){
            if(x % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }

        System.out.println("Max: " + max);

        System.out.print("Sorted list: ");
        for(int x : list){
            System.out.print(x + " ");
        }

        System.out.println("\nAverage: " + avg);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}