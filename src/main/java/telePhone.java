/**
 * Created by hanxiaodi on 17/7/17.
 */
public class telePhone {
    private String size;
    private String cpu;
    private int coachsize;

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public String getCpu(){
        return cpu;
    }

    public void  setCoachsize(int coachsize){
        this.coachsize =coachsize;
    }

    public int getCoachsize() {
        return coachsize;
    }

 @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
            telePhone other =(telePhone) obj;
            if(size!=other.size && cpu!=other.cpu && coachsize!=other.coachsize)
                return  false;

            return true;


    }
}
