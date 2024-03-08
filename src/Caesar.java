package crypto;

public class Caesar implements MenuCrittazione {

    private final int shift;


    public Caesar(int shift) {
        this.shift = shift;
    }

    public Caesar() {
        this(6);
    }

    public String decrypt(String data) {
        return this.shifter(data, this.shift * -1);
    }

    protected String shifter(String data, int shift){
        StringBuilder output = new StringBuilder(data.length());
        for(char singleChar : data.toCharArray()){
            int shiftedChar = (int) singleChar + shift;
            output.append((char) shiftedChar);
        }
        return output.toString();
    }
}
