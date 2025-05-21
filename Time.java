public interface Time {
    
    int Month();
    
    int Day();
    
    int Year();
    
    int Hour();

    int Minute();

    int Second();

    boolean isAM();

    @Override
    String toString();

    void clear();

    void reset();

}
