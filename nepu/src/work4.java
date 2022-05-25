class Topic{
    protected String name, Brd, Subject, topic;
    protected long number;
    protected int years;
    String getBrd(){
        return Brd;
    }
    String getName(){
        return name;
    }
    String getSubject(){
        return Subject;
    }
    String getTopic(){
        return topic;
    }
    long getNumber(){
        return number;
    }
    int getYears(){
        return years;
    }

    void list(String topic, String name, String Brd, long number, int years){
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("學號: "+ number);
        System.out.println("年級: "+ years);
    }
    void list(String topic, String name, String Brd, String Subject){
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("科目: "+ Subject);
    }



    Topic(String topic, String name, String Brd, long number, int years){
        this.Brd = Brd;
        this.name = name;
        this.number = number;
        this.years = years;
        this.topic = topic;
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("學號: "+ number);
        System.out.println("年級: "+ years + "\n");

    }
    Topic(String topic, String name, String Brd, String Subject){
        this.Brd = Brd;
        this.Subject = Subject;
        this.name = name;
        this.topic = topic;
        System.out.println(topic);
        System.out.println("姓名: "+ name);
        System.out.println("出生年: "+ Brd);
        System.out.println("科目: "+ Subject + "\n");
    }
    Topic(){}
}
class Sort extends Topic{
    Topic tl;
    void Sort(Topic[]Topics){
        for (int i = 0; i < Topics.length-1; i++) {
            if (Topics[i].getName().compareToIgnoreCase(Topics[i + 1].getName()) > 0) {
                tl = Topics[i];
                Topics[i] = Topics[i + 1];
                Topics[i + 1] = tl;
            }
        }
            System.out.println("now print out\n");
            for (Topic tc : Topics){
                if (tc.getTopic().equalsIgnoreCase("teacher")){
                    System.out.println(tc.getTopic());
                    System.out.println("姓名: "+ tc.getName());
                    System.out.println("出生年: "+ tc.getBrd());
                    System.out.println("科目: "+ tc.getSubject() + "\n");
                }
                else if (tc.getTopic().equalsIgnoreCase("student")){
                    System.out.println(tc.getTopic());
                    System.out.println("姓名: "+ tc.getName());
                    System.out.println("出生年: "+ tc.getBrd());
                    System.out.println("學號: "+ tc.getNumber());
                    System.out.println("年級: "+ tc.getYears());
                }
            }
    }
}

public class work4 {

    public static void main(String[] args) {
        Topic tc = new Topic("teacher", "bepu", "2b1", "math");
        Topic tc2 = new Topic("teacher", "aepu2", "4b1", "math");
        Topic tc3 = new Topic("Student", "nepu3", "4b20", 402185, 3);
        Topic tc4 = new Topic("teacher", "uepu4", "9b1", "math");
        Sort sort = new Sort();
        sort.Sort(new Topic[]{tc, tc2, tc3, tc4});
    }
}
