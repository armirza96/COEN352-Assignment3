package Question2;

public class Volume implements Comparable<Volume>{
	
    private String date;
    private long volume;

    Volume(String date, long volume) {
        this.date = date;
        this.volume = volume;
    }

    @Override
    public int compareTo(Volume vol) {
    	if(this.volume > vol.volume) {
    		return 1;
    	} else if (this.volume < vol.volume) {
    		return -1;
    	} else {
    		return 0;
    	}
    }

    @Override
    public String toString() {
        return date + "   " + volume;
    }
}
