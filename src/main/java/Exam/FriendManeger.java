package Exam;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendManeger {

    private List<Friend> friendList;

    public FriendManeger(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public void add(Friend friend) {
        friendList.add(friend);

    }

    public void remove(String phone) {
        for (Friend friend : friendList) {
            if (friend.getPhone().equals(phone)) {
                friendList.remove(friend);
            }

        }

    }

    public List<Friend> find(String name) {
        List<Friend> findFriend = new ArrayList<>();
        for(Friend friend : friendList){
            if (friend.getName().equals(name)){ //contains를 쓰면 포함된 단어로 찾을 수 있다.
                findFriend.add(friend);
            }
        }

        return findFriend;


    }

    public int friendCount() {
       return friendList.size();

    }

}

