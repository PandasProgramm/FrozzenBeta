package de.miguel.frozzenlist.frozzenbetaa;

import android.content.Context;
import android.os.Build;
import android.util.ArrayMap;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class UserManager {


    public ArrayList<User> userList;

    public UserManager(Context context){
        Hawk.init(context).build();
        loadList();

    }



    public void saveList(){
         Hawk.put("userList",userList);
    }
    public void loadList(){


        userList= Hawk.get("userList",new ArrayList<>());

    }
    public void addUser(User user){
        userList.add(user);
        saveList();
    }
    public void removeUser(int position){
        userList.remove(position);
        saveList();
    }
}
