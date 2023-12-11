import java.util.Scanner;
import java.util.ArrayList;

class Run_file{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Object>> D_processes= new ArrayList<>();

        System.out.println("Enter number of processes");
        int num_of_processes = input.nextInt();
        System.out.println("Enter number of processes");
        int contexts_witching = input.nextInt();
        for (int i = 0; i < num_of_processes; i++) {
            ArrayList<Object> D_process = new ArrayList<>();
            System.out.println("Enter the name of process " + i);
            String name = input.next();
            D_process.add(name);
            System.out.println("Enter the Process Arrival Time " + i);
            String Arr_time = input.next();
            D_process.add(Arr_time);
            System.out.println("Enter the Process Process Burst Time " + i);
            String Burst_time = input.next();
            D_process.add(Burst_time);
            System.out.println("Enter the Process Process Priority Number " + i);
            String priority_time = input.next();
            D_process.add(priority_time);
            D_processes.add(D_process);
        }

        int time_now = 0, max =99999;
        while (!D_processes.isEmpty()) {
            for (int i = 0; i < D_processes.size(); i++) {
                
            }
        }
    }
}