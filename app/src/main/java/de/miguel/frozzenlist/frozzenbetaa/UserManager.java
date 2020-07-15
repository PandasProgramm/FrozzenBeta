   package de.miguel.frozzenlist.frozzenbetaa;

   import android.content.Context;
   import android.os.Build;
   import android.util.ArrayMap;
   import android.view.View;

   import androidx.annotation.RequiresApi;

   import com.orhanobut.hawk.Hawk;

   import java.util.ArrayList;

    /**
    ==============================================================
     @author Miguel Gutierrez, project FrozzenList
     @version 1.0Beta
     @param: save Userunit: Hawk to saveList,loadList and addUser
     @Link userManager
    ==============================================================
    */

   @RequiresApi(api = Build.VERSION_CODES.KITKAT)
   public class UserManager {

    public ArrayList<User> userList;

    //Instance
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
