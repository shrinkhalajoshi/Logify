//package com.anuj.signin;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatDialogFragment;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class WeightDialog extends AppCompatDialogFragment {
//    EditText weight,reps;
//    @NonNull
//    @Override
//
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.layout_dialog,null);
//
//        builder.setView(view)
//                .setTitle("Log")
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//
//                    }
//                })
//                .setPositiveButton("Log", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//
//
//                        FirebaseDatabase.getInstance().getReference("Users")
//                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("weight")
//                                .setValue(weight);
//                    }
//                });
//
//
//        weight = view.findViewById(R.id.editTextWeight);
//        reps  = view.findViewById(R.id.editTextReps);
//    return builder.create();
//    }
//
//    public interface WeightDialogListener{
//
//
//    }
//}
