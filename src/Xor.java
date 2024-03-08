package crypto;

public class XOR implements MenuCrittazione {

    private final String chiave;

    public XOR(String chiave) {
        this.chiave = chiave;
    }

    public XOR() {
        this("my_secret");
    }



    public String crypt(String data) {
        return null;
    }

    public String decrypt(String data) {
        return this.xorAlgo(data);
    }

    private String xorAlgo(String data){
        String acc = " ";
        for(int i=0; i<data.length(); i++){
            char d = data.charAt(i);
            for(int j=0; j<chiave.length(); j++){
                char k = chiave.charAt(j);
                char xorChar = (char) (d ^ k);
                acc = acc + xorChar;
            }
        }
        return acc;
    }
}


