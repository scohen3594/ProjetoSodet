package br.ufpe.cin.movies;

public class Session {

    private String day;
    private String hour;
    private Room room;
    private boolean dubbed;
    private boolean threeD;

    public Session(String day, String hour, boolean dubbed, boolean threeD, String name, int id){
        this.day = day;
        this.hour = hour;
        room = new Room(id, name);
        this.dubbed = dubbed;
        this.threeD = threeD;
    }

    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day = day;
    }

    public String getHour(){
        return hour;
    }

    public void setHour(String hour){
        this.hour = hour;
    }

    public Room getRoom(){
        return room;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public boolean getDubbed(){
        return dubbed;
    }

    public void setDubbed(boolean dubbed){
        this.dubbed = dubbed;
    }

    public boolean getThreeD(){
        return threeD;
    }

    public void setThreeD(boolean threeD){
        this.threeD = threeD;
    }
}
