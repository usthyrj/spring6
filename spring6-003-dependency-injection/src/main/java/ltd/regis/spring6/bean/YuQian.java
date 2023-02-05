package ltd.regis.spring6.bean;

import java.util.Arrays;

public class YuQian {

    private String[] hobbies;
    private Friend[] friends;

    @Override
    public String toString() {
        return "YuQian{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", friends=" + Arrays.toString(friends) +
                '}';
    }

    public void setFriends(Friend[] friends) {
        this.friends = friends;
    }

    public void setHobbies(String[] hobby) {
        this.hobbies = hobby;
    }

}
