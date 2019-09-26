package hutsalod.game.nevelnex;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import static hutsalod.game.nevelnex.MainActivity.bar1;
import static hutsalod.game.nevelnex.MainActivity.bar2;
import static hutsalod.game.nevelnex.MainActivity.bar3;
import static hutsalod.game.nevelnex.MainActivity.hr;
import static hutsalod.game.nevelnex.MainActivity.life;
import static hutsalod.game.nevelnex.MainActivity.toUsersZodiac;
import static hutsalod.game.nevelnex.MainActivity.txtVs;
import static hutsalod.game.nevelnex.MainActivity.westatus;
import static hutsalod.game.nevelnex.MainActivity.zrlove;
import static hutsalod.game.nevelnex.MainActivity.zrsex;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    static private int vs,vss,vsy,proc;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(createDialogView());
        return builder.create();

    }
    private void vs(int cout){
        switch (hr) {
            case (1):vss=0;break;
            case (2):vss=1;break;
            case (3):vss=2;break;
            case (4):vss=3;break;
            case (5):vss=4;break;
            case (6):vss=5;break;
            case (7):vss=6;break;
            case (8):vss=5;break;
            case (9):vss=4;break;
            case (10):vss=3;break;
            case (11):vss=2;break;
            case (12):vss=1;break;
        }
    }


    private void diSet(int vs){
        this.vs = vs;
        switch (vs) {
            case(1):westatus.setText(R.string.h1);vsy=5;break;
            case(2):westatus.setText(R.string.h2);vsy=4;break;
            case(3):westatus.setText(R.string.h3);vsy=3;break;
            case(4):westatus.setText(R.string.h4);vsy=2;break;
            case(5):westatus.setText(R.string.h5);vsy=1;break;
            case(6):westatus.setText(R.string.h6);vsy=2;break;
            case(7):westatus.setText(R.string.h7);vsy=3;break;
            case(8):westatus.setText(R.string.h8);vsy=4;break;
            case(9):westatus.setText(R.string.h9);vsy=5;break;
            case(10):westatus.setText(R.string.h10);vsy=6;break;
            case(11):westatus.setText(R.string.h11);vsy=7;break;
            case(12):westatus.setText(R.string.h12);vsy=8;break;
        }
        dismiss();
        proc = 100-vss-vsy;
        zrlove.setText("" + (proc-7));
        zrsex.setText("" + (proc-10));
        life.setText("" + (proc-4));
        bar1.setProgress(proc-7);
        bar2.setProgress(proc-10);
        bar3.setProgress(proc-4);

            switch (vss+vsy) {
                case (1):txtVs.setText(R.string.vs1); break;
                case (2):txtVs.setText(R.string.vs2); break;
                case (3):txtVs.setText(R.string.vs3); break;
                case (4):txtVs.setText(R.string.vs4); break;
                case (5):txtVs.setText(R.string.vs5); break;
                case (6):txtVs.setText(R.string.vs6); break;
                case (7):txtVs.setText(R.string.vs7); break;
                case (8):txtVs.setText(R.string.vs8); break;
                case (9):txtVs.setText(R.string.vs9); break;
                case (10):txtVs.setText(R.string.vs10); break;
                case (11):txtVs.setText(R.string.vs11); break;
                case (12):txtVs.setText(R.string.vs12); break;
                case (13):txtVs.setText(R.string.vs13); break;
                case (14):txtVs.setText(R.string.vs14); break;
                case (15):txtVs.setText(R.string.vs15); break;
                case (16):txtVs.setText(R.string.vs16); break;
                case (17):txtVs.setText(R.string.vs17); break;
                case (18):txtVs.setText(R.string.vs18); break;
                case (19):txtVs.setText(R.string.vs19); break;
                case (20):txtVs.setText(R.string.vs20); break;
                case (21):txtVs.setText(R.string.vs21); break;
                case (22):txtVs.setText(R.string.vs22); break;
                case (23):txtVs.setText(R.string.vs23); break;
                case (24):txtVs.setText(R.string.vs24); break;
            }
    }



    private View createDialogView() {
        View dialog = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_dialog, null, false);

        dialog.findViewById(R.id.btn_logout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(1);
                toUsersZodiac.setImageResource(R.drawable.ic_zod9);
            }
        });
        dialog.findViewById(R.id.btn_logout2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(2);
                toUsersZodiac.setImageResource(R.drawable.ic_zod7);
            }
        });
        dialog.findViewById(R.id.btn_logout3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(3);
                toUsersZodiac.setImageResource(R.drawable.ic_zod5);
            }
        });
        dialog.findViewById(R.id.btn_logout4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(4);
                toUsersZodiac.setImageResource(R.drawable.ic_zod4);
            }
        });
        dialog.findViewById(R.id.btn_logout5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(5);
                toUsersZodiac.setImageResource(R.drawable.ic_zod3);
            }
        });
        dialog.findViewById(R.id.btn_logout6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(6);
                toUsersZodiac.setImageResource(R.drawable.ic_zod6);
            }
        });
        dialog.findViewById(R.id.btn_logout7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(7);
                toUsersZodiac.setImageResource(R.drawable.ic_zod11);
            }
        });
        dialog.findViewById(R.id.btn_logout8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(8);
                toUsersZodiac.setImageResource(R.drawable.ic_zod12);
            }
        });
        dialog.findViewById(R.id.btn_logout9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(9);
                toUsersZodiac.setImageResource(R.drawable.ic_zod10);
            }
        });
        dialog.findViewById(R.id.btn_logout10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(10);
                toUsersZodiac.setImageResource(R.drawable.ic_zod2);
            }
        });
        dialog.findViewById(R.id.btn_logout11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(11);
                toUsersZodiac.setImageResource(R.drawable.ic_zod8);
            }
        });
        dialog.findViewById(R.id.btn_logout12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diSet(12);
                toUsersZodiac.setImageResource(R.drawable.ic_zod1);
            }
        });

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String username, String password);
    }


}
