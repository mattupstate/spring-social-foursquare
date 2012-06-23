package org.springframework.social.foursquare.api;

public class VenueBeenHere {
    private int count;
    private boolean marked;
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
