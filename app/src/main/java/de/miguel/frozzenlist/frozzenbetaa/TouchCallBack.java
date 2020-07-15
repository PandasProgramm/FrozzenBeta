package de.miguel.frozzenlist.frozzenbetaa;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class TouchCallBack extends ItemTouchHelper.SimpleCallback {


    UserManager userManager;
    int position;
    RecyclerView recyclerView;
    /**
     * Creates a Callback for the given drag and swipe allowance. These values serve as
     * defaults
     * and if you want to customize behavior per ViewHolder, you can override
     * {@link #:getSwipeDirs(RecyclerView, ViewHolder)}
     * and / or {@link #:getDragDirs(RecyclerView, ViewHolder)}.
     *
     * @param: dragDirs  Binary OR of direction flags in which the Views can be dragged. Must be
     *                  composed of {@link #:LEFT}, {@link #:RIGHT}, {@link #:START}, {@link
     *                  #:END},
     *                  {@link #:UP} and {@link #:DOWN}.
     * @param: swipeDirs:Binary OR of direction flags in which the Views can be swiped. Must be
     *                  composed of {@link #:LEFT}, {@link #:RIGHT}, {@link #:START}, {@link
     *                  #:END},
     *                  {@link #:UP} and {@link #:DOWN}.
     */
    public TouchCallBack(UserManager userManager,int position,RecyclerView recyclerView) {
        super(ItemTouchHelper.DOWN|ItemTouchHelper.UP, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        this.userManager= userManager;
        this.position=position;
        this.recyclerView=recyclerView;

    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        Freezer freezer= userManager.userList.get(position).freezers.get(viewHolder.getAdapterPosition());
        int oldPosition= viewHolder.getAdapterPosition();
        int newPosition= target.getAdapterPosition();
        userManager.userList.get(position).freezers.remove(oldPosition);
        userManager.userList.get(position).freezers.add(newPosition,freezer);
        userManager.saveList();
        recyclerView.getAdapter().notifyItemMoved(oldPosition,newPosition);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        userManager.userList.get(position).freezers.remove(viewHolder.getAdapterPosition());
        recyclerView.getAdapter().notifyItemRemoved(viewHolder.getAdapterPosition());
        userManager.saveList();
    }
}
