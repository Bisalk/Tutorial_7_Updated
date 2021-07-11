import java.util.ArrayList;

public class Player {

    private String name;
    private int age;
    private String type;
    private ArrayList<Integer> statistics;


    public Player(String name,int age,String type,ArrayList<Integer> statistics){
        this.setName(name);
        this.setAge(age);
        this.setType(type);
        this.setStatistics(statistics);
    }

    public double getAverage(){
        int total=0;

        for(int i=0;i<statistics.size();i++){
            total+= this.getStatistics().get(i);
        }

        return total/(double)statistics.size();
    }

    public void getPlayerDetails(){
        System.out.printf("""
                Player Name: %s
                Age: %s
                Type: %s
                Player Statistics: %s
                """, this.getName(), this.getAge(), this.getType(), this.getStatistics());
    }

    public int getBestPerformance(){
        int max= getStatistics().get(0);

        for(int i=0;i<statistics.size();i++){

            if(getStatistics().get(i)>max){
                max= getStatistics().get(i);
            }
        }
        return max;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Integer> getStatistics() {
        return statistics;
    }

    public void setStatistics(ArrayList<Integer> statistics) {
        this.statistics = statistics;
    }
}
