import java.util.Scanner;
import java.util.ArrayList;

class Non_preemptive_Priority_Scheduling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Object>> D_processes = new ArrayList<>();

        System.out.println("Enter number of processes");
        int num_of_processes = input.nextInt();
       
        System.out.println("Enter the context switch");
        int context_switch = input.nextInt();
        for (int i = 0; i < num_of_processes; i++) {
            ArrayList<Object> D_process = new ArrayList<>();

            // push the name of process number i in D_processes array list
            System.out.println("Enter the name of process " + (i + 1));
            String name = input.next();
            D_process.add(name);

            // push the Arrival Time of process number i in D_processes array list
            System.out.println("Enter the Process Arrival Time " + (i + 1));
            int Arr_time = input.nextInt();
            D_process.add(Arr_time);

            // push the Burst Time of process number i in D_processes array list
            System.out.println("Enter the Process Process Burst Time " + (i + 1));
            int Burst_time = input.nextInt();
            D_process.add(Burst_time);

            // push the Priority of process number i in D_processes array list
            System.out.println("Enter the Process Process Priority Number " + (i + 1));
            int priority_time = input.nextInt();
            D_process.add(priority_time);

            D_processes.add(D_process);
        }

        int time_now = 0, current_process = 0, wait_time_tracking = 20, total_turnaroud_time=0, total_waiting_time=0;
        while (!D_processes.isEmpty()) {
            int max = 99999;
            for (int i = 0; i < D_processes.size(); i++) {
                ArrayList<Object> process = D_processes.get(i);
                int arrival_time = (int) process.get(1);
                int priority = (int) process.get(3);
               
                //solve starvation
                if(time_now - arrival_time >= wait_time_tracking && priority > 1){
                    process.set(3,priority - 1);
                }
                if (arrival_time <= time_now && priority < max) {
                    max = priority;
                    current_process = i;
                }
            }

            ArrayList<Object> currentProcess = D_processes.get(current_process);
            System.out.println("Current process's name: " + currentProcess.get(0) +
                    " Current process's priority: " + currentProcess.get(3));

            int waiting_time = time_now - (int)currentProcess.get(1);
            D_processes.remove(current_process);
            System.out.println("Waiting time : " + waiting_time);
            System.out.println("TurnAround time : " + ((int)currentProcess.get(2)));
            total_turnaroud_time += (int)currentProcess.get(2);
            total_waiting_time += waiting_time;

            time_now += (int) currentProcess.get(2) + context_switch;
            try {
                 Thread.sleep(context_switch);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Average Waiting Time : " + total_waiting_time/num_of_processes);
        System.out.println("Average Turnaround Time : " + total_turnaroud_time/num_of_processes);
    }
}
