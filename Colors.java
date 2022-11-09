import java.util.*;
import java.util.stream.Collectors;

public class Colors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        HashMap<String, Integer> box = new LinkedHashMap<>();
        while (!command.equals("End")){
            String [] input = command.split(" +", -1);
            String color = input[0].replace(":","");
            int count = Integer.parseInt(input[1]);
            if (box.containsKey(color)){
                box.put(color, box.get(color)+ count);
            } else {
                box.put(color, count);
            }
            command = scanner.nextLine();
        }

        Map<String,Integer> minimum =
                box.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                        .limit(box.size()-1)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int sum = 0;

       for (Map.Entry<String, Integer> value: minimum.entrySet()){
           sum += value.getValue();
        }
        System.out.println(sum);
    }
}
